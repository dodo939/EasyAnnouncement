package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MainCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            Help.on(commandSender);
        } else if (strings.length == 1) {
            switch (strings[0]) {
                case "enable":
                    Enable.on(commandSender);
                    break;
                case "help":
                    Help.on(commandSender);
                    break;
                case "reload":
                    Reload.on(commandSender);
                    break;
                case "status":
                    Status.on(commandSender);
                    break;
                case "show":
                    Show.on(commandSender);
                    break;
                case "disable":
                    Disable.on(commandSender);
                    break;
                default:
                    commandSender.sendMessage(Utils.tr("commands.unknown"));
            }
        } else {
            if (strings[0].equals("set")) {
                if (strings[1].equals("interval")) {
                    SetInterval.on(commandSender, strings);
                } else if (strings[1].equals("content")) {
                    SetContent.on(commandSender, strings);
                } else {
                    commandSender.sendMessage(Utils.tr("commands.unknown"));
                }
            } else if (strings[0].equals("language")) {
                Language.on(commandSender, strings[1]);
            } else {
                commandSender.sendMessage(Utils.tr("commands.unknown"));
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) {
            if (commandSender.isOp()) {
                return EasyAnnouncement.opTabList;
            } else {
                return EasyAnnouncement.notOpTabList;
            }
        } else if (strings.length == 2) {
            if (strings[0].equals("set")) {
                if (commandSender.isOp()) {
                    return EasyAnnouncement.setTabList;
                }
            } else if (strings[0].equals("language")) {
                if (commandSender.isOp()) {
                    return EasyAnnouncement.languageTabList;
                }
            }
        }
        return null;
    }
}
