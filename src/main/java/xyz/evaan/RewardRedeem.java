package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;

public class RewardRedeem {
    public RewardRedeem(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(RewardRedeemedEvent.class, event -> onRedeem(event));
    }

    public void onRedeem(RewardRedeemedEvent event) {
        if (event.toString().toLowerCase().contains("title=reward name here,")) { // replace reward name here with the name of the reward, very jank but it works :)
            Bot.twitchClient.getChat().sendMessage(Bot.twitchName, event.getRedemption().getUser().getDisplayName() + " has redeemed the test reward!");
        }
    }
}
