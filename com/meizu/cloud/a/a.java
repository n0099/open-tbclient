package com.meizu.cloud.a;

import android.content.Context;
import android.os.Environment;
import com.meizu.cloud.pushsdk.base.h;
/* loaded from: classes3.dex */
public class a {
    public static boolean debug = false;

    public static void d(String str, String str2) {
        h.b().a(str, str2);
    }

    public static void e(String str, String str2) {
        h.b().d(str, str2);
    }

    public static void eF(Context context) {
        h.b().a(context);
        h.b().a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName());
    }

    public static void flush() {
        h.b().a(false);
    }

    public static void i(String str, String str2) {
        h.b().b(str, str2);
    }
}
