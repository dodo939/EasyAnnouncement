package love.dodo939.easyannouncement;

import love.dodo939.easyannouncement.Commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public final class EasyAnnouncement extends JavaPlugin {
    public static Logger logger = null;
    public static ResourceBundle messages_en = ResourceBundle.getBundle("en_us");;
    public static ResourceBundle messages_cn = ResourceBundle.getBundle("zh_cn");
    public static ResourceBundle messages = messages_en;
    public static boolean isPluginOn = true;
    public static List<String> opTabList = new ArrayList<>();
    public static List<String> notOpTabList = new ArrayList<>();
    public static List<String> setTabList = new ArrayList<>();
    public static List<String> languageTabList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger = getLogger();

        // Load config file
        logger.info("Loading config file...");
        if (!new File(getDataFolder(), "config.yml").exists()) {
            logger.info("The config file doesn't exist. Loading default config file...");
            saveDefaultConfig();
        }
        boolean enable = getConfig().getBoolean("enable");
        int interval = getConfig().getInt("interval");
        if (Objects.equals(getConfig().getString("language"), "zh_cn")) {
            messages = messages_cn;
        }
        List<String> content = getConfig().getStringList("content");
        // check config
        if (interval <= 0) {
            interval = 1;
            getConfig().set("interval", 1);
            saveConfig();
            reloadConfig();
            logger.warning("The interval is invalid. Now it's set to 1");
        }

        // Launch timer
        logger.info("Loading GlobalTimer...");
        GlobalTimer timer = new GlobalTimer(enable, interval, content);
        timer.start();

        // Load commands
        logger.info("Loading commands...");
        Objects.requireNonNull(getCommand("easyannouncement")).setExecutor(new MainCommand());
        opTabList.add("enable");
        opTabList.add("disable");
        opTabList.add("reload");
        opTabList.add("set");
        opTabList.add("show");
        opTabList.add("status");
        opTabList.add("help");
        opTabList.add("language");
        notOpTabList.add("status");
        notOpTabList.add("help");
        setTabList.add("interval");
        setTabList.add("content");
        languageTabList.add("en_us");
        languageTabList.add("zh_cn");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        isPluginOn = false;
    }
}
