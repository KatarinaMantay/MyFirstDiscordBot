package kat.dev.events;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class LoveYouEvent extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getChannel().getName().equalsIgnoreCase("iloveyou")) {
            return;
        }

        MessageChannel channel = event.getChannel();
        String messageContent = event.getMessage().getContentStripped();

        if (messageContent.equalsIgnoreCase("I love you bot")) {
            event.getChannel().sendMessage("I love you " + event.getAuthor().getName() + " <3").queue();

            }
        }
    }

