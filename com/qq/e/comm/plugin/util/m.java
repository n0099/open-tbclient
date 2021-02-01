package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
public class m {
    public static boolean a(double d) {
        return d == 0.0d;
    }

    public static boolean a(int i) {
        int integer = GDTADManager.getInstance().getSM().getInteger("video_duration_setting_min", 5);
        int integer2 = GDTADManager.getInstance().getSM().getInteger("video_duration_setting_max", 60);
        if (i < integer || i > integer2) {
            GDTLogger.e("setMaxVideoDuration Illegal param ");
            return false;
        }
        return true;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(String str) {
        return a((Object) str) || str.trim().length() == 0;
    }

    public static boolean a(String str, String str2) {
        if (a(str) || a(str2)) {
            return false;
        }
        return str2.substring(0, str2.lastIndexOf(".")).equals(str.substring(0, str.lastIndexOf(".")));
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }
}
