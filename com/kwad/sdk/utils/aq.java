package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes10.dex */
public final class aq {
    public static String aNX = "";
    public static volatile Boolean aNY;

    public static String KA() {
        try {
            Object callStaticMethod = s.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            if (!(callStaticMethod instanceof String)) {
                return "";
            }
            return (String) callStaticMethod;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String Kz() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return "";
    }

    public static String ct(@NonNull Context context) {
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

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(aNX)) {
            return aNX;
        }
        String Kz = Kz();
        aNX = Kz;
        if (!TextUtils.isEmpty(Kz)) {
            return aNX;
        }
        String KA = KA();
        aNX = KA;
        if (!TextUtils.isEmpty(KA)) {
            return aNX;
        }
        String ct = ct(context);
        aNX = ct;
        return ct;
    }

    public static boolean isInMainProcess(Context context) {
        boolean z;
        if (aNY == null) {
            String processName = getProcessName(context);
            if (!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName())) {
                z = true;
            } else {
                z = false;
            }
            aNY = Boolean.valueOf(z);
        }
        return aNY.booleanValue();
    }
}
