package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.common.enums.CommandPermission;
import com.github.twitch4j.common.events.user.PrivateMessageEvent;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ChannelMessage {
    public ChannelMessage(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(ChannelMessageEvent.class, event -> onMessage(event));
    }

    public void onMessage(ChannelMessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("*stop") && event.getPermissions().contains(CommandPermission.MODERATOR))
            Runtime.getRuntime().exit(0); // if chat message is *stop and user is mod, it will stop the program. pretty much just used for a test.
    }
}
