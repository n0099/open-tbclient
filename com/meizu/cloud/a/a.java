package com.meizu.cloud.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.meizu.cloud.pushsdk.common.base.c;
import com.meizu.cloud.pushsdk.common.util.Logger;
import com.meizu.cloud.pushsdk.common.util.g;
/* loaded from: classes3.dex */
public class a {
    private static c iAS;
    public static boolean iAR = false;
    public static boolean debug = false;

    public static void dw(Context context) {
        if (iAS == null) {
            iAS = new c(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
            Logger.a(iAS);
            debug = g.b(context);
            Log.e("DebugLogger", "isOnDebug " + iAR + " debugConfig " + debug + " isDebuggable " + cco());
            if (!cco()) {
                Logger.a(Logger.Out.CONSOLE, Logger.Callback.Level.NULL);
            }
        }
    }

    public static boolean cco() {
        return iAR || debug;
    }

    public static void i(String str, String str2) {
        Logger.b(str, str2);
    }

    public static void d(String str, String str2) {
        Logger.a(str, str2);
    }

    public static void e(String str, String str2) {
        Logger.d(str, str2);
    }
}
