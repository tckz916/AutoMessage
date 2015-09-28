package com.github.tckz916.automessage.task;

import com.github.tckz916.automessage.AutoMessage;
import com.github.tckz916.automessage.util.Util;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class MessageTask {

    private static AutoMessage plugin = AutoMessage.getInstance();
    private static BukkitTask msgtask;
    private static int count;
    private static int i = 0;

    private static final Charset CONFIG_CHAREST = StandardCharsets.UTF_8;

    //private static final Charset CONFIG_CHAREST=Charset.forName("windows-31j");
    public static void onMessageTask() {

        count = plugin.getConfig().getInt(AutoMessage.getSecond());

        msgtask = new BukkitRunnable() {

            @Override
            public void run() {

                String confFilePath = plugin.getDataFolder() + File.separator + "config.yml";
                try (Reader reader = new InputStreamReader(new FileInputStream(confFilePath), CONFIG_CHAREST)) {
                    FileConfiguration conf = new YamlConfiguration();
                    conf.load(reader);

                    String prefix = conf.getString(AutoMessage.getPrefix());
                    List<String> msgs = conf.getStringList(AutoMessage.getList());
                    if (msgs.size() == i) {
                        i = 0;
                    }
                    Util.broadmessage(prefix + msgs.get(i).replace("%newline%", "\n"));
                } catch (Exception e) {
                }
                i++;
            }
        }.runTaskTimer(plugin, 0L, count * 20L);
    }

    public static void offMessageTask(BukkitTask task) {
        task.cancel();
    }

    public static BukkitTask getMsgtask() {
        return msgtask;
    }
}
