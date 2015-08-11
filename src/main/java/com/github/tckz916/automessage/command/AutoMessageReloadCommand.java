package com.github.tckz916.automessage.command;

import com.github.tckz916.automessage.AutoMessage;
import com.github.tckz916.automessage.task.MessageTask;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class AutoMessageReloadCommand implements CommandExecutor {

    private AutoMessage plugin = AutoMessage.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("automessage.reload")) {
            plugin.reloadConfig();
            MessageTask.offMessageTask(MessageTask.getMsgtask());
            MessageTask.onMessageTask();
        }
        return true;
    }
}
