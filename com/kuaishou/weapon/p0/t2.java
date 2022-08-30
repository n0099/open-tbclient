package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u2 a;

    public t2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new u2();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                u2 u2Var = new u2();
                int a = u2Var.a(TelephonyManager.class, "getDeviceId", new Object[0]);
                if (a > 0) {
                    jSONObject.put("0", a);
                }
                int a2 = u2Var.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
                if (a2 > 0) {
                    jSONObject.put("1", a2);
                }
                int a3 = u2Var.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
                if (a3 > 0) {
                    jSONObject.put("2", a3);
                }
                int a4 = u2Var.a(Location.class, "getLatitude", new Object[0]);
                if (a4 > 0) {
                    jSONObject.put("3", a4);
                }
                int a5 = u2Var.a(Location.class, "getLongitude", new Object[0]);
                if (a5 > 0) {
                    jSONObject.put("4", a5);
                }
                int a6 = u2Var.a(WifiInfo.class, "getMacAddress", new Object[0]);
                if (a6 > 0) {
                    jSONObject.put("6", a6);
                }
                int a7 = u2Var.a(WifiInfo.class, "getBSSID", new Object[0]);
                if (a7 > 0) {
                    jSONObject.put("7", a7);
                }
                int a8 = u2Var.a(WifiInfo.class, "getRssi", new Object[0]);
                if (a8 > 0) {
                    jSONObject.put("8", a8);
                }
                int a9 = u2Var.a(JSONObject.class, "toString", new Object[0]);
                if (a9 > 0) {
                    jSONObject.put("9", a9);
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int a = this.a.a();
                if (a <= 0) {
                    return null;
                }
                int a2 = this.a.a(a, TelephonyManager.class, "getDeviceId", new Object[0]);
                if (a2 > 0) {
                    jSONObject.put("0", a2);
                }
                int a3 = this.a.a(a, TelephonyManager.class, "getSubscriberId", new Object[0]);
                if (a3 > 0) {
                    jSONObject.put("1", a3);
                }
                int a4 = this.a.a(a, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
                if (a4 > 0) {
                    jSONObject.put("2", a4);
                }
                int a5 = this.a.a(a, Location.class, "getLatitude", new Object[0]);
                if (a5 > 0) {
                    jSONObject.put("3", a5);
                }
                int a6 = this.a.a(a, Location.class, "getLongitude", new Object[0]);
                if (a6 > 0) {
                    jSONObject.put("4", a6);
                }
                int a7 = this.a.a(a, WifiInfo.class, "getMacAddress", new Object[0]);
                if (a7 > 0) {
                    jSONObject.put("6", a7);
                }
                int a8 = this.a.a(a, WifiInfo.class, "getBSSID", new Object[0]);
                if (a8 > 0) {
                    jSONObject.put("7", a8);
                }
                int a9 = this.a.a(a, WifiInfo.class, "getRssi", new Object[0]);
                if (a9 > 0) {
                    jSONObject.put("8", a9);
                }
                int a10 = this.a.a(a, JSONObject.class, "toString", new Object[0]);
                if (a10 > 0) {
                    jSONObject.put("9", a10);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
