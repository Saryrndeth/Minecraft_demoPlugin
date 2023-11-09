package org.saryrndeth.demo2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.saryrndeth.demo2.inventory.TestGUI;

public class OpenInv implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            TestGUI inv = new TestGUI();
            inv.open(player);
        }
        return false;
    }
}
