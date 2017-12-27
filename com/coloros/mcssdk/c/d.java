package com.coloros.mcssdk.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class d {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            c.b("parseInt--NumberFormatException" + e.getMessage());
            return -1;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            c.b("isExistPackage NameNotFoundException:" + e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            c.b("isSupportPush NameNotFoundException:" + e.getMessage());
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.metaData.getBoolean(str2, false);
        }
        return false;
    }

    public static int b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            c.a("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }
}
