package kat.dev.events;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GoodMorningEvent extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }

        MessageChannel channel = event.getChannel();
        String messageContent = event.getMessage().getContentStripped();

        if (messageContent.equalsIgnoreCase("good morning bot")) {
            event.getChannel().sendMessage("Good morning " + event.getAuthor().getName() + "!").queue();

        }
    }
}


