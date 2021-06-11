package com.yy.hiidostatis.provider;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class MessageConfigFactory {
    public static ConcurrentHashMap<String, MessageConfig> caches = new ConcurrentHashMap<>();
    public static MessageConfig mainConfig = null;

    public static MessageConfig generate(Context context, String str) {
        MessageConfig messageConfig = caches.get(str);
        if (messageConfig != null) {
            return messageConfig;
        }
        synchronized (MessageConfigFactory.class) {
            MessageConfig messageConfig2 = caches.get(str);
            if (messageConfig2 != null) {
                return messageConfig2;
            }
            MessageConfig messageConfig3 = new MessageConfig(context, str, false);
            caches.put(str, messageConfig3);
            return messageConfig3;
        }
    }

    public static MessageConfig generateMainConfig(Context context, String str) {
        MessageConfig messageConfig = mainConfig;
        if (messageConfig != null) {
            return messageConfig;
        }
        synchronized (MessageConfigFactory.class) {
            if (mainConfig != null) {
                return mainConfig;
            }
            MessageConfig messageConfig2 = new MessageConfig(context, str, true);
            mainConfig = messageConfig2;
            caches.put(str, messageConfig2);
            return mainConfig;
        }
    }

    public static MessageConfig getMainConfig() {
        return mainConfig;
    }
}
