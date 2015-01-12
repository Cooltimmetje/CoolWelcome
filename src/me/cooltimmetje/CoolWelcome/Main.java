package me.cooltimmetje.CoolWelcome;

import me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core.ConfigManager;
import me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class has been created on 11-1-2015 at 16:04 by cooltimmetje.
 */

@SuppressWarnings("unused")
public class Main extends JavaPlugin {
    private static Plugin plugin;
    private long loadTime;

    public void onEnable() {
        startLoad();
        plugin = this;
        getLogger().info("===================[CoolWelcome]===================");
        getLogger().info("Setting up...");

        getLogger().info("Registering events...");
        registerEvents(this, new JoinEvent());

        getLogger().info("Reading config...");
        ConfigManager.onEnableConfig();

//        getLogger().info("Registering commands...");
//        getCommand("command").setExecutor(new Class());

//        getLogger().info("Hooking into APIs...");
//        if(getServer().getPluginManager().getPlugin("plugin")) != null && getServer().getPluginManager().getPlugin("plugin").isEnabled()){
//            getLogger().info("Successfully hooked into plugin!");
//        } else{
//            getLogger().warning("Failed to hook into plugin, disabling plugin!");
//            getPluginLoader().disablePlugin(this);
//        }
        stopLoad();
        Bukkit.broadcastMessage(Main.tag + "This server is running CoolWelcome!");
    }

    public void onDisable(){
        plugin = null;
        getServer().resetRecipes();
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners){
        for(Listener listener : listeners){
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    public void startLoad(){
        loadTime = System.currentTimeMillis();
    }

    public void stopLoad(){
        loadTime = System.currentTimeMillis() - loadTime;
        getLogger().info("Ready! (" + loadTime + "ms)");
        getLogger().info("===================[CoolWelcome]===================");
    }

    public static String tag = "&8[&bCoolWelcome&8] &3".replace('&', '§');
    public static int configVersion = 1;
}
