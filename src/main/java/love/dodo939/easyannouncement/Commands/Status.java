package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;

public class Status {
    public static void on(CommandSender commandSender) {
        commandSender.sendMessage(Utils.tr("commands.status.title"));
        commandSender.sendMessage(Utils.tr("commands.status.version", "1.0"));
        commandSender.sendMessage(Utils.tr(GlobalTimer.isEnabled ? "commands.status.on" : "commands.status.off"));
        commandSender.sendMessage(Utils.tr("commands.status.interval", GlobalTimer.interval));
        if (GlobalTimer.isEnabled) {
            commandSender.sendMessage(Utils.tr("commands.status.left", GlobalTimer.interval - GlobalTimer.current));
        }
        commandSender.sendMessage(Utils.tr("commands.status.content"));
        for (String line : GlobalTimer.content) {
            commandSender.sendMessage(" §7- §r" + line);
        }
    }
}
