package org.saryrndeth.demo2;

import org.bukkit.plugin.java.JavaPlugin;
import org.saryrndeth.demo2.commands.Help;
import org.saryrndeth.demo2.event.BreakEvent;

public final class Demo2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin active!");
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginCommand("thelp").setExecutor(new Help());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deactive!");
        // Plugin shutdown logic
    }
}
