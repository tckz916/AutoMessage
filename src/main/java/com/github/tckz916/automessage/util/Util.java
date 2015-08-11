package com.github.tckz916.automessage.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by tckz916 on 2015/07/11.
 */
public class Util {

    public static String coloring(String str) {
        return str.replaceAll("&([0-9a-fk-or])", "\u00A7$1");
    }

    public static void broadmessage(String message) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage(coloring(message));
        }
    }

}
