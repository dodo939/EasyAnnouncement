package love.dodo939.easyannouncement.Commands;

import love.dodo939.easyannouncement.EasyAnnouncement;
import love.dodo939.easyannouncement.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Language {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(EasyAnnouncement.class);

    public static void on(CommandSender commandSender, String language) {
        if (commandSender.isOp()) {
            if (language.equals("en_us")) {
                EasyAnnouncement.messages = EasyAnnouncement.messages_en;
                plugin.getConfig().set("language", "en_us");
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage("§bLanguage has been switched to English");
            } else if (language.equals("zh_cn")) {
                EasyAnnouncement.messages = EasyAnnouncement.messages_cn;
                plugin.getConfig().set("language", "zh_cn");
                plugin.saveConfig();
                plugin.reloadConfig();
                commandSender.sendMessage("§b语言已切换为简体中文");
            } else {
                commandSender.sendMessage(Utils.tr("commands.invalid_syntax"));
            }
        } else {
            commandSender.sendMessage(Utils.tr("commands.no_permission"));
        }
    }
}
