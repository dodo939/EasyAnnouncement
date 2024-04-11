package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;

public class Help {
    public static void on(CommandSender commandSender) {
        commandSender.sendMessage(Utils.tr("commands.help.title"));
        if (commandSender.isOp()) {
            commandSender.sendMessage(Utils.tr("commands.help.enable"));
            commandSender.sendMessage(Utils.tr("commands.help.disable"));
            commandSender.sendMessage(Utils.tr("commands.help.reload"));
            commandSender.sendMessage(Utils.tr("commands.help.show"));
            commandSender.sendMessage(Utils.tr("commands.help.interval"));
            commandSender.sendMessage(Utils.tr("commands.help.content"));
            commandSender.sendMessage(Utils.tr("commands.help.language"));
        }
        commandSender.sendMessage(Utils.tr("commands.help.status"));
        commandSender.sendMessage(Utils.tr("commands.help.help"));
    }
}
