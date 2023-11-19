package org.saryrndeth.demo2.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.saryrndeth.demo2.inventory.TestGUI;

import java.util.Arrays;

public class OpenInv implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (!player.getGameMode().name().equalsIgnoreCase("spectator")) {
                player.sendMessage("관전자 모드가 아니면 사용할 수 없습니다.");
            }
            else {
                if (strings.length != 1) {
                    player.sendMessage("사용법: /openinv <플레이어>");
                    return false;
                }
                PlayerInventory inv = Bukkit.getPlayer(strings[0]).getInventory();
                player.openInventory(inv);
            }
        }
        return false;
    }
}
