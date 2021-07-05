package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002e: INVOKE  (r0v6 int A[REMOVE]) = 
      (wrap: android.telephony.TelephonyManager : 0x0027: CHECK_CAST (r0v5 android.telephony.TelephonyManager A[REMOVE]) = (android.telephony.TelephonyManager) (wrap: java.lang.Object : 0x0023: INVOKE  (r0v4 java.lang.Object A[REMOVE]) = (r0v3 android.content.Context), ("phone") type: VIRTUAL call: android.content.Context.getSystemService(java.lang.String):java.lang.Object))
     type: VIRTUAL call: android.telephony.TelephonyManager.getNetworkType():int)] */
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(((TelephonyManager) appContext.getSystemService("phone")).getNetworkType());
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject a(PM pm) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pm)) == null) {
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

    public static JSONObject a(SM sm) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sm)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (sm != null) {
                jSONObject.putOpt("suid", sm.getSuid());
                jSONObject.putOpt("sid", sm.getSid());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aPPStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (aPPStatus != null) {
                jSONObject.putOpt(com.alipay.sdk.sys.a.f1936i, aPPStatus.getAPPName());
                jSONObject.putOpt("appkey", aPPStatus.getAPPID());
                jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
                jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, deviceStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (deviceStatus != null) {
                jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
                jSONObject.putOpt(Config.DEVICE_NAME, deviceStatus.getDataNet());
                String a2 = a();
                if (!StringUtil.isEmpty(a2)) {
                    jSONObject.putOpt("cell_native", a2);
                }
                jSONObject.putOpt(SuggestAddrField.KEY_LAT, deviceStatus.getLat());
                jSONObject.putOpt(SuggestAddrField.KEY_LNG, deviceStatus.getLng());
                for (Map.Entry<String, String> entry : deviceStatus.getLacAndCeilId().entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
