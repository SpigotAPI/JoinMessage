package com.ambrosia.joinmessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class JoinMessage extends JavaPlugin implements Listener {
	
	public static JoinMessage instance;
	
	public void onEnable() {
		
		instance = this;
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		saveDefaultConfig();
		reloadConfig();
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		for(int x = 0; x < 255; x++) {
			player.sendMessage("");
		}
		
		for(String message : instance.getConfig().getStringList("joinMessage")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
		}
	}
}
