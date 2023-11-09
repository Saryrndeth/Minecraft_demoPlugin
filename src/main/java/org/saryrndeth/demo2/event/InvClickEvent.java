package org.saryrndeth.demo2.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) return;

        if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("TEST GUI")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            player.sendMessage("인벤토리 클릭이 취소되었습니다.");
        }
    }
}
