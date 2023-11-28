package com.kwad.library.solder.lib;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes10.dex */
public final class a {
    public static String wL() {
        return "";
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", z(str, str2));
    }

    public static String z(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + wL();
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", z(str, str2), th);
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", z(str, ""), th);
    }
}
