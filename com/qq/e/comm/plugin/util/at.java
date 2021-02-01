package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes15.dex */
public class at {
    public static void a(String str, int i) {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void a(String str, long j) {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void a(String str, String str2) {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static int b(String str, int i) {
        return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getInt(str, i);
    }

    public static long b(String str, long j) {
        return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getLong(str, j);
    }

    public static String b(String str, String str2) {
        return GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0).getString(str, str2);
    }
}
