package com.minecraftdimensions.chestrefill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class ChestManager {
	public static ArrayList<Chest> chests = new ArrayList<>();
	public static ArrayList<DoubleChest> doubleChests = new ArrayList<>();
	public static HashMap<Integer,ItemStack[]> chestValues= new HashMap<>();
	ArrayList<Chest> emptiedChests = new ArrayList<>();
	public static int REFIL_TIMER;
	
	public static void processChunk(BlockState[] blocks){
		for(BlockState b: blocks){
			if(b instanceof DoubleChest){
				addDoubleChest((DoubleChest)b);
			}else
			if(b instanceof Chest){
				addChest((Chest)b);
			}
		}
	}
	
	private static void addDoubleChest(DoubleChest c) {
		if(isChestEmpty(c.getInventory())){
			fillChest(c.getInventory(), 1);
		}
		
	}

	public static void addChest(Chest c){
		if(isChestEmpty(c.getInventory())){
			fillChest(c.getInventory(), 1);
		}
	}
	
	public static boolean isChestEmpty(Inventory i){
		for(ItemStack is:i.getContents()){
			if(is!=null){
				return false;
			}
		}
		return true;
	}
	
	public static void fillChest(final Inventory i, int multiplier){
		Bukkit.getScheduler().runTask(ChestRefill.instance, new Runnable(){

			@Override
			public void run() {
				final Random random = new Random();
				int ran = random.nextInt(9)+1;
				System.out.println("Filling with "+ ran );
				int x = 0;
				for(ItemStack is: chestValues.get(ran)){
					i.setItem(x, is);
					System.out.println(is.getAmount());
					x++;
				}
			}
			
		});
	}

	public static void loadChestTypes() {
		FileConfiguration c =ChestRefill.config;
		REFIL_TIMER =c.getInt("refil-timer");
		
		Random random = new Random();
		
		int chestnum = 0;
		for(int i=10; chestnum<i;chestnum++){
			ItemStack[] stack = new ItemStack[2];
			int ran1= random.nextInt(64)+1;
			int ran2= random.nextInt(64)+1;
			stack[0]= new ItemStack(Material.ANVIL,ran1);
			System.out.println(ran1);
			stack[1]= new ItemStack(Material.ANVIL,ran2);
			System.out.println(ran2);
			System.out.println(chestnum);
			chestValues.put(chestnum, stack);
		}
	}
	
	
	
	

}
