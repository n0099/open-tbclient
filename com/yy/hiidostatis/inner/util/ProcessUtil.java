package com.yy.hiidostatis.inner.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.List;
/* loaded from: classes8.dex */
public final class ProcessUtil {
    public static String mCurProcessName;

    public static String getCurProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str = mCurProcessName;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str2 = runningAppProcessInfo.processName;
                        mCurProcessName = str2;
                        return str2;
                    }
                }
            }
        } catch (Throwable th) {
            L.debug("ProcessUtil", "getCurProcessName exceptioon: %s", th);
        }
        return null;
    }

    public static boolean isBackground(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            L.debug("ProcessUtil", "isBackground exceptioon: %s", th);
            return false;
        }
    }

    public static String getFileNameBindProcess(Context context, String str) {
        try {
            if (!isMainProcess(context)) {
                return String.format("%s_%s", str, Integer.valueOf(Coder.encryptMD5(getCurProcessName(context)).hashCode()));
            }
            return str;
        } catch (Throwable th) {
            L.debug("ProcessUtil", "fileName[%s] instead of it,exception on getFileNameBindProcess: %s ", str, th);
            return str;
        }
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getApplicationInfo().processName.equals(getCurProcessName(context));
        } catch (Throwable th) {
            L.debug("ProcessUtil", "isMainProcess exceptioon: %s", th);
            return false;
        }
    }
}
