package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class SystemUtil {
    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (StringUtil.isEmpty(processName)) {
            return str;
        }
        boolean endsWith = processName.endsWith("_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(endsWith ? "" : "_");
        sb.append(Md5Util.encode(processName));
        return sb.toString();
    }

    public static String getProcessName(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    next = it.next();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (next.pid == myPid) {
                    return next.processName;
                }
                continue;
            }
            return null;
        }
        return null;
    }
}
