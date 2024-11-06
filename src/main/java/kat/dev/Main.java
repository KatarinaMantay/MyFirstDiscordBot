package kat.dev;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static kat.dev.EventRegister.registerEvents;

public class Main {

    public static void main(String[] args) throws LoginException, FileNotFoundException {

        Gson gson = new Gson();
        Config config = null;
        String token = "";

        try {
            config = gson.fromJson(new FileReader("src/main/resources/config.json"), Config.class);
            token = config.getDISCORD_TOKEN();
        }
        catch (JsonIOException e) {
            System.err.println("Failed");
            return;
        }
        catch (IOException e) {
            System.err.println("Failed");
            return; // Exit
        }

        JDA jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).build();

        registerEvents(jda);
    }

}