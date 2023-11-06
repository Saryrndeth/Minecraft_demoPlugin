package org.saryrndeth.demo2.event;

import java.util.logging.Logger;
import org.saryrndeth.demo2.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {
    private static final Logger logger = Logger.getLogger(BreakEvent.class.getName());
    @EventHandler
    public void breakDirt(BlockBreakEvent e) {
        Material brBlock = e.getBlock().getBlockData().getMaterial();
        if(brBlock == Material.DIRT || brBlock == Material.GRASS_BLOCK) {
            Player p = e.getPlayer();
            if(Math.floor(Math.random() * 10) < 5) {
                p.getInventory().addItem(ItemManager.dia);
                p.getInventory().addItem(ItemManager.dia2);
                p.sendMessage("땅파서 다이아 발견");
            }
            else {
                p.getInventory().addItem(ItemManager.sword);
                p.getInventory().addItem(ItemManager.dia3);
            }
        }
    }
}
