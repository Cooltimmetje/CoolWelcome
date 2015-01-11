package me.cooltimmetje.CoolWelcome.me.cooltimmetje.CoolWelcome.Core;

import me.cooltimmetje.CoolWelcome.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * This class has been created on 11-1-2015 at 16:52 by cooltimmetje.
 */

@SuppressWarnings("unused")
public class JoinEvent implements Listener {
    public static int amount = 0;

    @EventHandler
    public void onFirstPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (!p.hasPlayedBefore()) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(amount);
            String amountString = sb.toString();
            Bukkit.broadcastMessage((Main.getPlugin().getConfig().get("settings.welcome_message").toString().replace("{0}", p.getName()).replace("{1}", amountString).replace('&', '§')));
            amount = amount + 1;
            ConfigManager.writeConfig();
        }
    }
}
