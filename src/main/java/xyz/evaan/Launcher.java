package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;

public class Launcher {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must add the account username and access token in the arguments.");
            return;
        }
        Bot twitchBot = new Bot(args[0], args[1]);
        Bot.eventHandler = Bot.twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);
        twitchBot.registerEvents();
        System.out.println("The bot is now initialized!");
    }
}
