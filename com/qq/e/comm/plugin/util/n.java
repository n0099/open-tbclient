package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class n {
    public static int a() {
        return SDKStatus.getSDKVersionCode() >= 20 ? 1 : 0;
    }

    public static com.qq.e.comm.plugin.y.d a(LoadAdParams loadAdParams) {
        if (loadAdParams == null) {
            return null;
        }
        return new com.qq.e.comm.plugin.y.d().a("la", loadAdParams.getLoginAppId()).a("lt", loadAdParams.getLoginType()).a("lo", loadAdParams.getLoginOpenid()).a(NotificationStyle.EXPANDABLE_IMAGE_URL, loadAdParams.getExtraInfo());
    }

    public static com.qq.e.comm.plugin.y.d a(com.qq.e.comm.plugin.ad.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new com.qq.e.comm.plugin.y.d().a("la", bVar.y()).a("lt", bVar.x()).a("lo", bVar.v()).a(NotificationStyle.EXPANDABLE_IMAGE_URL, bVar.H());
    }

    private static String a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "@None@";
    }

    public static JSONObject a(Context context, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.EVENT_PAGE_MAPPING, Process.myPid());
            jSONObject.put(Config.PACKAGE_NAME, a(context));
            jSONObject.put("td", Thread.currentThread().getId());
            jSONObject.put(CashierData.TN, Thread.currentThread().getName());
            if (obj != null) {
                jSONObject.put("oh", obj.hashCode());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
