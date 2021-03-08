package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002c: INVOKE  (r0v12 int A[REMOVE]) = 
      (wrap: android.telephony.TelephonyManager : 0x0025: CHECK_CAST (r0v11 android.telephony.TelephonyManager A[REMOVE]) = (android.telephony.TelephonyManager) (wrap: java.lang.Object : 0x0021: INVOKE  (r0v10 java.lang.Object A[REMOVE]) = (r2v0 android.content.Context), ("phone") type: VIRTUAL call: android.content.Context.getSystemService(java.lang.String):java.lang.Object))
     type: VIRTUAL call: android.telephony.TelephonyManager.getNetworkType():int)] */
    private static String a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return null;
            }
            return new StringBuilder().append(((TelephonyManager) appContext.getSystemService("phone")).getNetworkType()).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject a(PM pm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
        jSONObject.putOpt("sdk_st", 1);
        return jSONObject;
    }

    public static JSONObject a(SM sm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, sm.getSid());
        }
        return jSONObject;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt("an", aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
            jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
        }
        return jSONObject;
    }

    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt(Config.DEVICE_NAME, deviceStatus.getDataNet());
            String a2 = a();
            if (!StringUtil.isEmpty(a2)) {
                jSONObject.putOpt("cell_native", a2);
            }
            jSONObject.putOpt("lat", deviceStatus.getLat());
            jSONObject.putOpt("lng", deviceStatus.getLng());
            for (Map.Entry<String, String> entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
