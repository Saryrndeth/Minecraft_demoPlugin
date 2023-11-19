package org.saryrndeth.demo2.commands;

import org.saryrndeth.demo2.Demo2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Gamestart implements CommandExecutor{

    public static double[] pos = {0, 0, 0};
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender.isOp())) {
            commandSender.sendMessage("권한이 없습니다.");
            return false;
        }
        Player player = (Player) commandSender;
        /* stop players' movement */
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set day");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:slowness 1000000 255 true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:blindness 1000000 255 true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:resistance 1000000 255 true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:regeneration 1000000 255 true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:mining_fatigue 1000000 255 true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "advancement revoke @a everything");
        /* get player's pos*/
        pos[0] = player.getLocation().getX();
        pos[1] = player.getLocation().getY();
        pos[2] = player.getLocation().getZ();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + (int) Math.round(pos[0] - 10) + " " + (int) Math.round(pos[1] - 1) + " " + (int) Math.round(pos[2] - 10) + " " + (int) Math.round(pos[0] + 10) + " " + (int) Math.round(pos[1] + 10) + " " + (int) Math.round(pos[2] + 10) + " bedrock hollow");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=item]");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear @a");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp @a " + pos[0] + " " + pos[1] + " " + pos[2]);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survival @a");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder center " + pos[0] + " " + pos[2]);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setworldspawn " + pos[0] + " " + pos[1] + " " + pos[2]);
        int num = (int) Math.round(Math.random() * 10000);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set " + num);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\": \"설정중...\",\"color\":\"red\"}");
        new BukkitRunnable(){
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\":\"경계 크기: " + "\",\"color\":\"red\"}");
                new BukkitRunnable(){
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\":\"경계 크기: " + num + "\",\"color\":\"red\"}");
                    }
                }.runTaskLater(Demo2.getPlugin(Demo2.class), 60);
                new BukkitRunnable(){
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a subtitle {\"text\": \"중심: " + "\",\"color\":\"white\"}");
                        new BukkitRunnable(){
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a subtitle {\"text\": \"중심: " + (int) Math.round(pos[0]) + ", " + (int) Math.round(pos[2]) + "\",\"color\":\"white\"}");
                                int[] invtime = {30, 60, 90, 120, 150, 180, 210 , 240, 270, 300};
                                /* choose randomly one value in invtime array */
                                int inv = invtime[(int) Math.round(Math.random() * 9)];
                                /* sleep five seconds */
                                new BukkitRunnable(){
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a clear");
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\": \"무적시간:" + "\",\"color\":\"white\"}");
                                        new BukkitRunnable(){
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\": \"무적시간: " + inv + "\",\"color\":\"white\"}");
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        readyCount();
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear @a");
                                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + (int) Math.round(pos[0] - 10) + " " + (int) Math.round(pos[1] - 1) + " " + (int) Math.round(pos[2] - 10) + " " + (int) Math.round(pos[0] + 10) + " " + (int) Math.round(pos[1] + 10) + " " + (int) Math.round(pos[2] + 10) + " air");
                                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a resistance " + inv + " 255 true");
                                                            }}.runTaskLater(Demo2.getPlugin(Demo2.class), 100);
                                                    };
                                                }.runTaskLater(Demo2.getPlugin(Demo2.class), 40);

                                            }
                                        }.runTaskLater(Demo2.getPlugin(Demo2.class), 60);
                                    }
                                }.runTaskLater(Demo2.getPlugin(Demo2.class), 60);
                                }
                        }.runTaskLater(Demo2.getPlugin(Demo2.class), 60);
                    }
                }.runTaskLater(Demo2.getPlugin(Demo2.class), 30);
            }
        }.runTaskLater(Demo2.getPlugin(Demo2.class), 60);

        return false;
    }

    private void readyCount() {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar 5");
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar 4");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar 3");
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar 2");
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar 1");
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar \"text\": \"게임시작!\"");
                                            };
                                        }.runTaskLater(Demo2.getPlugin(Demo2.class), 20);
                                    };
                                }.runTaskLater(Demo2.getPlugin(Demo2.class), 20);
                            };
                        }.runTaskLater(Demo2.getPlugin(Demo2.class), 20);
                    };
                }.runTaskLater(Demo2.getPlugin(Demo2.class), 20);
            };
        }.runTaskLater(Demo2.getPlugin(Demo2.class), 20);
    }

}
