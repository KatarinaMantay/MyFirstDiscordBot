package kat.dev.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class NewMemberJoinEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        Member member = event.getMember();
        String channelName = "joins";
        TextChannel channel = null;

        for (TextChannel textChannel : event.getGuild().getTextChannels()) {

            if (textChannel.getName().equalsIgnoreCase(channelName)) {
                channel = textChannel;
                break;
            }
        }

        if (channel != null) {
            channel.sendMessage("Welcome to Kat's Server " + member.getAsMention() + "!").queue();
        }
        else {
            System.out.println("Channel not found");
        }
    }
}
