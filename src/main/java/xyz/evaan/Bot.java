package xyz.evaan;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public class Bot {
    public static TwitchClient twitchClient;
    public static OAuth2Credential login;
    public static SimpleEventHandler eventHandler;

    public static final String twitchName = "TWITCHNAMEHERE";

    public Bot(String identityProvider, String accessToken) {
        login = new OAuth2Credential(identityProvider, accessToken);
        twitchClient = TwitchClientBuilder.builder()
                .withEnablePubSub(true)
                .withEnableChat(true)
                .withChatAccount(login)
                .build();
        twitchClient.getChat().joinChannel(twitchName);
        twitchClient.getPubSub().listenForChannelPointsRedemptionEvents(login, "59898043"); // you can grab this value at https://www.streamweasels.com/support/convert-twitch-username-to-user-id/
    }

    public void registerEvents() {
        ChannelMessage channelMessage = new ChannelMessage(eventHandler);
        RewardRedeem rewardRedeem = new RewardRedeem(eventHandler);
    }
}
