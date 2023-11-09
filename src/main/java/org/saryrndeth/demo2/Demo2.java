package org.saryrndeth.demo2;

import org.bukkit.plugin.java.JavaPlugin;
import org.saryrndeth.demo2.commands.*;
import org.saryrndeth.demo2.event.BreakEvent;
import org.saryrndeth.demo2.event.InvClickEvent;

public final class Demo2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin active!");
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginCommand("thelp").setExecutor(new Help());
        getServer().getPluginCommand("topeninv").setExecutor(new OpenInv());
        getServer().getPluginCommand("gamestart").setExecutor(new Gamestart());
        getServer().getPluginCommand("중심").setExecutor(new Center());
        getServer().getPluginCommand("test").setExecutor(new Test());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deactive!");
        // Plugin shutdown logic
    }
}
