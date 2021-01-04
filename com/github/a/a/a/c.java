package com.github.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes15.dex */
public class c {
    private static final Object pJZ = new Object();
    private static volatile String sProcessName;

    public static String eBF() {
        String str;
        if (sProcessName != null) {
            return sProcessName;
        }
        synchronized (pJZ) {
            if (sProcessName != null) {
                str = sProcessName;
            } else {
                sProcessName = io(com.github.a.a.c.eBv().provideContext());
                str = sProcessName;
            }
        }
        return str;
    }

    private static String io(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
