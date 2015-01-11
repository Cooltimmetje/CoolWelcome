package me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core;

import me.cooltimmetje.CoolWelcome.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has been created on 11-1-2015 at 16:52 by cooltimmetje.
 */

@SuppressWarnings("unused")
public class JoinEvent implements Listener{
    public static List<String> users = new ArrayList<String>();
    public static int amount = 0;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(!users.contains(p.getName())){
            return;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(amount);
            String amountString = sb.toString();
            Bukkit.broadcastMessage((Main.getPlugin().getConfig().get("settings.welcome_message").toString().replace("{0}", p.getName()).replace("{1}", amountString).replace('&', '§')));
            users.add(p.getName());
            amount = amount + 1;
            ConfigManager.writeConfig();
        }
    }
}
