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
public final class an {
    public static String anX = "";
    public static volatile Boolean anY;

    public static String cG(@NonNull Context context) {
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
        if (TextUtils.isEmpty(anX)) {
            String zN = zN();
            anX = zN;
            if (TextUtils.isEmpty(zN)) {
                String zO = zO();
                anX = zO;
                if (TextUtils.isEmpty(zO)) {
                    String cG = cG(context);
                    anX = cG;
                    return cG;
                }
                return anX;
            }
            return anX;
        }
        return anX;
    }

    public static boolean isInMainProcess(Context context) {
        if (anY == null) {
            String processName = getProcessName(context);
            anY = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return anY.booleanValue();
    }

    public static String zN() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    public static String zO() {
        try {
            Object b = q.b(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return b instanceof String ? (String) b : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
