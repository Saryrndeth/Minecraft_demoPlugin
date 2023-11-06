package org.saryrndeth.demo2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.saryrndeth.demo2.ItemManager;

public class GiveDia implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            switch (strings.length) {
                case 0:
                    commandSender.sendMessage("다이아가 지급되었습니다.");
                    player.getInventory().addItem(ItemManager.dia);
                    break;
                case 1:
                    if (strings[0].equalsIgnoreCase("enchant")) {
                        player.getInventory().addItem(ItemManager.sword);
                        commandSender.sendMessage("검이 지급되었습니다.");
                        break;
                    }
            }
            return true;
        } else {
            commandSender.sendMessage("콘솔 ㄴㄴ");
        }
        return false;
    }
}
