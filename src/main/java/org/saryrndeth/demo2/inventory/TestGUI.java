package org.saryrndeth.demo2.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.saryrndeth.demo2.ItemManager;

public class TestGUI implements Listener {
    private final Inventory inv;

    private void initItemSetting() {
        inv.setItem(0, ItemManager.dia);
    }

    public TestGUI() {
        this.inv = Bukkit.createInventory(null, 9, "Test GUI");
        initItemSetting();
    }

    public void open(Player player) {
        player.openInventory(inv);
    }
}
