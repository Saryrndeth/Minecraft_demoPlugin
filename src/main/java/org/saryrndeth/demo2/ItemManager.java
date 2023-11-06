package org.saryrndeth.demo2;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.saryrndeth.demo2.event.BreakEvent;

import java.util.Arrays;

public class ItemManager {

    private static final Logger logger = Logger.getLogger(BreakEvent.class.getName());
    private static ItemStack buildItem(Material type, int amount, String displayName, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        logger.info("first" + displayName);
        return stack;
    }

    private static ItemStack buildItem(Material type, int amount, String displayName, Enchantment enchant, int enchantlvl, boolean enchantRestrict, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        meta.addEnchant(enchant, enchantlvl, enchantRestrict);
        stack.setItemMeta(meta);
        logger.info("second" + displayName);
        return stack;
    }


    public static final ItemStack dia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA + "다이아몬드", "흙을 캐서 얻음", ChatColor.LIGHT_PURPLE + "보라색맛");

    public static final ItemStack dia2 = buildItem(Material.WOODEN_SWORD, 1, "빛나는 나무 검222", Enchantment.DAMAGE_ALL, 3, false, "빛난다");

    public static final ItemStack dia3 = buildItem(Material.DIAMOND, 1, ChatColor.AQUA + "다이아몬드", "흙을 캐서 얻음", ChatColor.LIGHT_PURPLE + "보라색맛");
    public static final ItemStack sword = buildItem(Material.WOODEN_SWORD, 1, "빛나는 나무 검", Enchantment.DAMAGE_ALL, 3, false, "빛난다");

}
