package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.managers.GDTADManager;
import java.util.List;
/* loaded from: classes15.dex */
public final class SystemUtil {
    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (StringUtil.isEmpty(processName)) {
            return str;
        }
        return str + (processName.endsWith(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) ? "" : PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + Md5Util.encode(processName);
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
                continue;
            }
        }
        return null;
    }
}
