package com.idlefish.flutterboost.containers;

import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
/* loaded from: classes6.dex */
public class BoostViewUtils {
    public static volatile XPlatformPlugin mInstance;

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
