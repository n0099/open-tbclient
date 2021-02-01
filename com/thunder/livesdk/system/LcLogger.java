package com.thunder.livesdk.system;

import android.util.Log;
/* loaded from: classes4.dex */
public class LcLogger {
    public static boolean enableLog = true;

    public static void d(String str) {
        if (enableLog) {
            Log.d("simple-lifecycle", str);
        }
    }
}
