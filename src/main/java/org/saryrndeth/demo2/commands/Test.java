package org.saryrndeth.demo2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.saryrndeth.demo2.Demo2;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        new BukkitRunnable(){
            public void run() {
                commandSender.sendMessage("테스트");
            }
        }.runTaskLater(Demo2.getPlugin(Demo2.class), 100);

        return false;
    }
}
