package com.github.tckz916.automessage;

import com.github.tckz916.automessage.command.AutoMessageReloadCommand;
import com.github.tckz916.automessage.task.MessageTask;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class AutoMessage extends JavaPlugin {

    private static AutoMessage instance;

    private static String prefix = "Prefix";

    private static String list = "Message";

    private static String second = "Second";

    public static String getPrefix() {
        return prefix;
    }

    public static String getList() {
        return list;
    }

    public static String getSecond() {
        return second;
    }

    public static AutoMessage getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;
        saveDefaultConfig();
        reloadConfig();

        getCommand("automessagereload").setExecutor(new AutoMessageReloadCommand());

        MessageTask.onMessageTask();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
