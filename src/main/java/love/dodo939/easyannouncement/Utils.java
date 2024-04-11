package love.dodo939.easyannouncement;

import java.text.MessageFormat;

public class Utils {
    private Utils() {}

    @SafeVarargs
    public static <T> String tr(String key, T... args) {
        return MessageFormat.format(EasyAnnouncement.messages.getString(key), args);
    }
}
