package org.saryrndeth.demo2.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InvClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) return;

        Player player = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        if(inv != null && player.getOpenInventory().getTopInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
