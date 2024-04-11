package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Disable {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender) {
        if (commandSender.isOp()) {
            GlobalTimer.isEnabled = false;
            plugin.getConfig().set("enable", false);
            plugin.saveConfig();
            plugin.reloadConfig();
            commandSender.sendMessage(Utils.tr("commands.disable"));
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
