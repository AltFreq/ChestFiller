package com.minecraftdimensions.chestrefill;

import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class ChestOpenEvent implements Listener{
	
	
    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e){
        if (e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest){
           System.out.println("Opened chest!");
        }
    }

}
