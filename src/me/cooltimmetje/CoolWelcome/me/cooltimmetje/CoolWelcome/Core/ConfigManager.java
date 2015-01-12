package me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core;

import me.cooltimmetje.CoolWelcome.Main;
import org.bukkit.configuration.Configuration;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * This class has been created on 11-1-2015 at 16:48 by cooltimmetje.
 */

@SuppressWarnings("unused")
public class ConfigManager {
    static Configuration config = Main.getPlugin().getConfig();

    public static void onEnableConfig() {

        Main.getPlugin().saveDefaultConfig();

        if(config.getInt("DoNotTouch.IfYouDoConfigWillReset") != Main.configVersion || !config.contains("DoNotTouch.IfYouDoConfigWillReset")){
            File configFile = new File(Main.getPlugin().getDataFolder(), "config.yml");
            configFile.delete();
            Main.getPlugin().saveDefaultConfig();
            Main.getPlugin().reloadConfig();
        }

        List<String> Players = config.getStringList("data.users");

        for (String s : Players) {
            JoinEvent.users.add(s);
        }
        JoinEvent.amount = config.getInt("data.amount");
    }

    public static void writeConfig(){
        config.set("data.amount", JoinEvent.amount);
        config.set("data.users", JoinEvent.users);
        Main.getPlugin().saveConfig();
    }
}
