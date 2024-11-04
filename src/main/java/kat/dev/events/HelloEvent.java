package kat.dev.events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class HelloEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        System.out.println("Received a message event."); // Debugging

        if (event.getAuthor().isBot()) return;

        MessageChannel channel = event.getChannel();
        String messageContent = event.getMessage().getContentStripped();

        if (messageContent.equalsIgnoreCase("hi")) {
            event.getChannel().sendMessage("Hello " + event.getAuthor().getName() + "!").queue();
            System.out.println("Message content: " + messageContent);
        }
    }
}