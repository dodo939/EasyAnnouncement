package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Enable {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender) {
        if (commandSender.isOp()) {
            GlobalTimer.isEnabled = true;
            plugin.getConfig().set("enable", true);
            plugin.saveConfig();
            plugin.reloadConfig();
            GlobalTimer.current = GlobalTimer.interval;
            commandSender.sendMessage(Utils.tr("commands.enable"));
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
