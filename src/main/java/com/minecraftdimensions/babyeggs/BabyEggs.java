package com.minecraftdimensions.babyeggs;




import org.bukkit.plugin.java.JavaPlugin;

public class BabyEggs extends JavaPlugin {


	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(
				new BabyEggsListener(), this);
	}


}
