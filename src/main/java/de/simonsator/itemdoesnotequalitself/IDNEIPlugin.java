package de.simonsator.itemdoesnotequalitself;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class IDNEIPlugin extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent pEvent) {
		ItemStack stone = new ItemStack(Material.valueOf("STONE"));
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			@Override
			public void run() {
				Inventory inv = Bukkit.createInventory(null, 9, "My");
				inv.setItem(1, stone);
				inv.setItem(1, stone);
				pEvent.getPlayer().openInventory(inv);
			}
		}, 80l);

	}

	@EventHandler
	public void onClick(InventoryClickEvent pEvent) {
		ItemStack stone = new ItemStack(Material.valueOf("STONE"));
		ItemStack item = pEvent.getCurrentItem();
		if (item != null)
			pEvent.getWhoClicked().sendMessage("This is the item which was put into the inventory: "
					+ item.equals(stone));
	}
}
