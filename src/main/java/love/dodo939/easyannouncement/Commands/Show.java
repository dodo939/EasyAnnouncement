package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;

public class Show {
    public static void on(CommandSender commandSender) {
        if (commandSender.isOp()) {
            GlobalTimer.show();
            commandSender.sendMessage(Utils.tr("commands.show_once"));
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
