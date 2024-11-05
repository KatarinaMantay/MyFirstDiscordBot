package kat.dev;

import kat.dev.events.*;
import net.dv8tion.jda.api.JDA;

public class EventRegister {
    public static void registerEvents(JDA jda){
        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new AboutEvent());
        jda.addEventListener(new NewMemberJoinEvent());
        jda.addEventListener(new OnStartup());
        jda.addEventListener(new LoveYouEvent());
        jda.addEventListener(new GoodMorningEvent());
    }

}
