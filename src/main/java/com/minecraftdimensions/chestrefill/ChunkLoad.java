package com.minecraftdimensions.chestrefill;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkLoad implements Listener {
	

	@EventHandler
	public void blockbreak(final ChunkLoadEvent e) {
		Bukkit.getScheduler().runTaskAsynchronously(ChestRefill.instance, new Runnable(){

			@Override
			public void run() {
				ChestManager.processChunk(e.getChunk().getTileEntities());
			}
			
		});
	}


	
}