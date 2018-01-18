package com.meizu.cloud.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.meizu.cloud.pushsdk.common.b.c;
import com.meizu.cloud.pushsdk.common.b.h;
import com.meizu.cloud.pushsdk.common.base.c;
/* loaded from: classes2.dex */
public class a {
    private static c iba;
    public static boolean iaZ = false;
    public static boolean debug = false;

    public static void db(Context context) {
        if (iba == null) {
            iba = new c(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
            com.meizu.cloud.pushsdk.common.b.c.a(iba);
            debug = h.b(context);
            Log.e("DebugLogger", "isOnDebug " + iaZ + " debugConfig " + debug + " isDebuggable " + bMY());
            if (!bMY()) {
                com.meizu.cloud.pushsdk.common.b.c.a(c.d.CONSOLE, c.a.EnumC0185a.NULL);
            }
        }
    }

    public static boolean bMY() {
        return iaZ || debug;
    }

    public static void i(String str, String str2) {
        com.meizu.cloud.pushsdk.common.b.c.b(str, str2);
    }

    public static void d(String str, String str2) {
        com.meizu.cloud.pushsdk.common.b.c.a(str, str2);
    }

    public static void e(String str, String str2) {
        com.meizu.cloud.pushsdk.common.b.c.d(str, str2);
    }
}
