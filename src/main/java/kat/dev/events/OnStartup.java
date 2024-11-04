package kat.dev.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnStartup extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {

        for (Guild guild : event.getJDA().getGuilds()) {

            String channelName = "admin";
            TextChannel channel = guild.getTextChannelsByName(channelName, true).stream().findFirst().orElse(null);

            if (channel != null) {
                channel.sendMessage("Successfully Started " + guild.getName()).queue();
            }
            else {
                System.out.println("channel not found");
            }
        }
    }
}