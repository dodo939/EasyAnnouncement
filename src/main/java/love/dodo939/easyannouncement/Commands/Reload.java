package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class Reload {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender) {
        if (commandSender.isOp()) {
            plugin.reloadConfig();
            GlobalTimer.isEnabled = plugin.getConfig().getBoolean("enable");
            int interval = plugin.getConfig().getInt("interval");
            if (Objects.equals(plugin.getConfig().getString("language"), "zh_cn")) {
                EasyAnnouncement.messages = EasyAnnouncement.messages_cn;
            }
            GlobalTimer.content = plugin.getConfig().getStringList("content");
            // check config
            if (interval <= 0) {
                interval = 1;
                plugin.getConfig().set("interval", 1);
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage(Utils.tr("commands.invalid_interval"));
            }
            GlobalTimer.interval = interval;
            commandSender.sendMessage(Utils.tr("commands.reload"));
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
