package com.qq.e.comm.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(PM pm) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pm)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
            jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
            jSONObject.putOpt("sdk_st", 1);
            jSONObject.putOpt("sdk_cnl", 1);
            if (!TextUtils.isEmpty("")) {
                jSONObject.putOpt("sdk_ex1", "");
            }
            if (!TextUtils.isEmpty("")) {
                jSONObject.putOpt("sdk_ex2", "");
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aPPStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (aPPStatus != null) {
                jSONObject.putOpt(com.alipay.sdk.sys.a.r, aPPStatus.getAPPName());
                jSONObject.putOpt("appkey", aPPStatus.getAPPID());
                jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
                jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[LOOP:0: B:18:0x006f->B:20:0x0075, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        InterceptResult invokeL;
        Context appContext;
        String str;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, deviceStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (deviceStatus != null) {
                jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
                jSONObject.putOpt("dn", deviceStatus.getDataNet());
                try {
                    activeNetworkInfo = ((ConnectivityManager) GDTADManager.getInstance().getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception unused) {
                }
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    str = "" + ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                    if (!StringUtil.isEmpty(str)) {
                        jSONObject.putOpt("cell_native", str);
                    }
                    for (Map.Entry<String, String> entry : deviceStatus.getLacAndCeilId().entrySet()) {
                        jSONObject.putOpt(entry.getKey(), entry.getValue());
                    }
                }
                str = null;
                if (!StringUtil.isEmpty(str)) {
                }
                while (r4.hasNext()) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(DeviceStatus deviceStatus) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, deviceStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (deviceStatus != null) {
                jSONObject.putOpt("did", deviceStatus.getDeviceId());
                jSONObject.putOpt("md", deviceStatus.model);
                jSONObject.putOpt("lg", deviceStatus.getLanguage());
                jSONObject.putOpt("w", Integer.valueOf(deviceStatus.getDeviceWidth()));
                jSONObject.putOpt("h", Integer.valueOf(deviceStatus.getDeviceHeight()));
                jSONObject.putOpt(Config.DEVICE_ID_SEC, Integer.valueOf(deviceStatus.getDeviceDensity()));
                jSONObject.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                jSONObject.putOpt("os", "android");
                jSONObject.putOpt("op", deviceStatus.getOperator());
                jSONObject.putOpt("mf", Build.MANUFACTURER);
                SharedPreferences sharedPreferences = GDTADManager.getInstance().getAppContext().getSharedPreferences("com.qq.e.sdkconfig", 0);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString("ltd", null);
                    String string2 = sharedPreferences.getString("lod", null);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.putOpt("td", string);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.putOpt(Config.OAID, string2);
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
