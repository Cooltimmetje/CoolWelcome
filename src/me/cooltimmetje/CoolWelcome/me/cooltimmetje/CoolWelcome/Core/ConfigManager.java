package me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core;

import me.cooltimmetje.CoolWelcome.Main;

/**
 * This class has been created on 11-1-2015 at 16:48 by cooltimmetje.
 */

@SuppressWarnings("unused")
public class ConfigManager {

    public static void onEnableConfig() {
        Main.getPlugin().saveDefaultConfig();
        JoinEvent.amount = Main.getPlugin().getConfig().getInt("data.amount");
    }

    public static void writeConfig(){
        Main.getPlugin().getConfig().set("data.amount", JoinEvent.amount);
        Main.getPlugin().saveConfig();
    }
}
