package love.dodo939.easyannouncement;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GlobalTimer implements Runnable {
    public static int current = 0;
    public static boolean isEnabled = false;
    public static int interval = 30;
    public static List<String> content = null;

    public GlobalTimer(boolean _enable, int _interval, List<String> _content) {
        isEnabled = _enable;
        interval = _interval;
        content = _content;
    }

    public static void show() {
        for (String msg : content) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(msg);
            }
        }
    }

    @Override
    public void run() {
        while (EasyAnnouncement.isPluginOn) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            current++;
            if (current >= interval) {
                current = 0;
                if (isEnabled) {
                    show();
                }
            }
        }
    }

    public void start() {
        (new Thread(this, "GlobalTimer")).start();
    }
}
