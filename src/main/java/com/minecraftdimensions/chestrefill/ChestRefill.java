package com.minecraftdimensions.chestrefill;




import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestRefill extends JavaPlugin {


	public static Plugin instance;
	public static FileConfiguration config;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(
				new ChunkLoad(), this);
		getServer().getPluginManager().registerEvents(
				new ChestOpenEvent(), this);
		config=getConfig();
		saveDefaultConfig();
		ChestManager.loadChestTypes();
		for(World w:Bukkit.getWorlds()){
			for(Chunk c: w.getLoadedChunks()){
				ChestManager.processChunk(c.getTileEntities());
			}
		}
	}


}
