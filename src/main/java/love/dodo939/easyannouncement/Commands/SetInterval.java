package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SetInterval {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender, String[] strings) {
        if (commandSender.isOp()) {
            if (strings.length != 3) {
                commandSender.sendMessage(Utils.tr("commands.unknown"));
                return;
            }
            int interval;
            try {
                interval = Integer.parseInt(strings[2]);
            } catch (NumberFormatException e) {
                commandSender.sendMessage(Utils.tr("commands.invalid_syntax"));
                return;
            }
            if (interval <= 0) {
                commandSender.sendMessage(Utils.tr("commands.low_interval"));
            } else {
                GlobalTimer.interval = interval;
                commandSender.sendMessage(Utils.tr("commands.set_interval.set", String.valueOf(interval)));
                GlobalTimer.current = interval;
                plugin.getConfig().set("interval", interval);
                plugin.saveConfig();
                plugin.reloadConfig();
            }
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
