package com.meizu.cloud.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.meizu.cloud.pushsdk.common.b.c;
import com.meizu.cloud.pushsdk.common.b.h;
import com.meizu.cloud.pushsdk.common.base.c;
/* loaded from: classes2.dex */
public class a {
    private static c iac;
    public static boolean iab = false;
    public static boolean debug = false;

    public static void db(Context context) {
        if (iac == null) {
            iac = new c(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
            com.meizu.cloud.pushsdk.common.b.c.a(iac);
            debug = h.b(context);
            Log.e("DebugLogger", "isOnDebug " + iab + " debugConfig " + debug + " isDebuggable " + bNq());
            if (!bNq()) {
                com.meizu.cloud.pushsdk.common.b.c.a(c.d.CONSOLE, c.a.EnumC0269a.NULL);
            }
        }
    }

    public static boolean bNq() {
        return iab || debug;
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
