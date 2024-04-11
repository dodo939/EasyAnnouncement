package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.GlobalTimer;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SetContent {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender, String[] strings) {
        if (commandSender.isOp()) {
            if (strings.length < 3) {
                commandSender.sendMessage(Utils.tr("commands.unknown"));
                return;
            }
            String tmp = String.join(" ", Arrays.copyOfRange(strings, 2, strings.length));
            List<String> content = Arrays.stream(tmp.split("\\\\n"))
                                        .map(line -> line.replace("&", "§"))
                                        .collect(Collectors.toList());
            GlobalTimer.content = content;
            plugin.getConfig().set("content", content);
            plugin.saveConfig();
            plugin.reloadConfig();
            commandSender.sendMessage(Utils.tr("commands.content.modified"));
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
