package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes8.dex */
public class al {
    public static String a = "";

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
                    String b3 = b(context);
                    a = b3;
                    return b3;
                }
                return a;
            }
            return a;
        }
        return a;
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            return invoke instanceof String ? (String) invoke : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b(@NonNull Context context) {
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
