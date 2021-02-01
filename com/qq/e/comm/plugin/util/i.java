package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
/* loaded from: classes15.dex */
public class i {
    public static long a(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return new File(context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).length();
        } catch (Exception e) {
            GDTLogger.d("Get apk size encounter exception: " + e.getMessage());
            return 0L;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        String str = context.getApplicationInfo().packageName;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            return false;
        }
        return str.equals(resolveActivity.activityInfo.packageName);
    }

    public static boolean c(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 1) == 0) ? false : true;
    }
}
