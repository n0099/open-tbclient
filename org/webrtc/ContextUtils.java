package org.webrtc;

import android.content.Context;
/* loaded from: classes9.dex */
public class ContextUtils {
    public static final String TAG = "ContextUtils";
    public static Context applicationContext;

    @Deprecated
    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void initialize(Context context) {
        if (context != null) {
            applicationContext = context;
            return;
        }
        throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
    }
}
