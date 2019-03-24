package me.gabrielblink.galaxyhook.LC;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import galaxy.gabrielblink.GalaxyFactions.GalaxyAPI;
import galaxy.gabrielblink.GalaxyFactions.Enums.Cargo;

public class Core extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		Bukkit.getConsoleSender().sendMessage("§a[GalaxyHook] Inicializando Hook Galaxy Factions....");
		Bukkit.getPluginManager().registerEvents(this, this);
		super.onEnable();
	}
	
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	
	@EventHandler
	private void onHook(ChatMessageEvent e) {
	    if(e.getTags().contains("g_fac_tag")) {
	     if(GalaxyAPI.getFactionGalaxyUser(e.getSender().getName())!=null && GalaxyAPI.getFactionGalaxyUser(e.getSender().getName()).hasFac()) {
	    	e.setTagValue("g_fac_tag","§7["+Cargo.getTagIcon(GalaxyAPI.getFactionGalaxyUser(e.getSender().getName()).getCargo())+GalaxyAPI.getFactionGalaxyUser(e.getSender().getName()).getFaction().getTag()+"] ");
	     }else {
	    	 e.setTagValue("g_fac_tag", "");
	     }
	    }
	}

}
