package org.saryrndeth.demo2.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.saryrndeth.demo2.commands.Gamestart;

public class Center implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(Gamestart.pos[0] == 0 || Gamestart.pos[2] == 0) {
            player.sendMessage("중심이 설정되지 않았습니다.");
            return false;
        }
        player.sendMessage("중심: " + (int) Math.round(Gamestart.pos[0]) + ", " + (int) Math.round(Gamestart.pos[2]));
        return false;
    }
}
