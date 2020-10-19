package com.idlefish.flutterboost.containers;

import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
/* loaded from: classes12.dex */
class BoostViewUtils {
    private static volatile XPlatformPlugin mInstance;

    private BoostViewUtils() {
    }

    public static XPlatformPlugin getPlatformPlugin(PlatformChannel platformChannel) {
        if (mInstance == null) {
            synchronized (BoostViewUtils.class) {
                if (mInstance == null) {
                    mInstance = new XPlatformPlugin(platformChannel);
                }
            }
        }
        return mInstance;
    }
}
