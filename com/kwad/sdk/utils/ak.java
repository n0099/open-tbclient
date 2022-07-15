package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes5.dex */
public final class ak {
    public static String a = "";
    public static volatile Boolean b;

    public static String a() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    public static String a(@NonNull Context context) {
        if (TextUtils.isEmpty(a)) {
            String a2 = a();
            a = a2;
            if (TextUtils.isEmpty(a2)) {
                String b2 = b();
                a = b2;
                if (TextUtils.isEmpty(b2)) {
                    String c = c(context);
                    a = c;
                    return c;
                }
                return a;
            }
            return a;
        }
        return a;
    }

    public static String b() {
        try {
            Object a2 = q.a(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return a2 instanceof String ? (String) a2 : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean b(Context context) {
        if (b == null) {
            String a2 = a(context);
            b = Boolean.valueOf(!TextUtils.isEmpty(a2) && a2.equals(context.getPackageName()));
        }
        return b.booleanValue();
    }

    public static String c(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }
}
