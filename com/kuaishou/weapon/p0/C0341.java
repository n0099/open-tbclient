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
/* renamed from: com.kuaishou.weapon.p0.ʼᵔ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0341 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public C0342 f134;

    public C0341() {
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
        this.f134 = new C0342();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m291() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0342 c0342 = new C0342();
                int m298 = c0342.m298(TelephonyManager.class, "getDeviceId", new Object[0]);
                if (m298 > 0) {
                    jSONObject.put("0", m298);
                }
                int m2982 = c0342.m298(TelephonyManager.class, "getSubscriberId", new Object[0]);
                if (m2982 > 0) {
                    jSONObject.put("1", m2982);
                }
                int m2983 = c0342.m298(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
                if (m2983 > 0) {
                    jSONObject.put("2", m2983);
                }
                int m2984 = c0342.m298(Location.class, "getLatitude", new Object[0]);
                if (m2984 > 0) {
                    jSONObject.put("3", m2984);
                }
                int m2985 = c0342.m298(Location.class, "getLongitude", new Object[0]);
                if (m2985 > 0) {
                    jSONObject.put("4", m2985);
                }
                int m2986 = c0342.m298(WifiInfo.class, "getMacAddress", new Object[0]);
                if (m2986 > 0) {
                    jSONObject.put("6", m2986);
                }
                int m2987 = c0342.m298(WifiInfo.class, "getBSSID", new Object[0]);
                if (m2987 > 0) {
                    jSONObject.put("7", m2987);
                }
                int m2988 = c0342.m298(WifiInfo.class, "getRssi", new Object[0]);
                if (m2988 > 0) {
                    jSONObject.put("8", m2988);
                }
                int m2989 = c0342.m298(JSONObject.class, "toString", new Object[0]);
                if (m2989 > 0) {
                    jSONObject.put("9", m2989);
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject m292() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int m296 = this.f134.m296();
                if (m296 <= 0) {
                    return null;
                }
                int m297 = this.f134.m297(m296, TelephonyManager.class, "getDeviceId", new Object[0]);
                if (m297 > 0) {
                    jSONObject.put("0", m297);
                }
                int m2972 = this.f134.m297(m296, TelephonyManager.class, "getSubscriberId", new Object[0]);
                if (m2972 > 0) {
                    jSONObject.put("1", m2972);
                }
                int m2973 = this.f134.m297(m296, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
                if (m2973 > 0) {
                    jSONObject.put("2", m2973);
                }
                int m2974 = this.f134.m297(m296, Location.class, "getLatitude", new Object[0]);
                if (m2974 > 0) {
                    jSONObject.put("3", m2974);
                }
                int m2975 = this.f134.m297(m296, Location.class, "getLongitude", new Object[0]);
                if (m2975 > 0) {
                    jSONObject.put("4", m2975);
                }
                int m2976 = this.f134.m297(m296, WifiInfo.class, "getMacAddress", new Object[0]);
                if (m2976 > 0) {
                    jSONObject.put("6", m2976);
                }
                int m2977 = this.f134.m297(m296, WifiInfo.class, "getBSSID", new Object[0]);
                if (m2977 > 0) {
                    jSONObject.put("7", m2977);
                }
                int m2978 = this.f134.m297(m296, WifiInfo.class, "getRssi", new Object[0]);
                if (m2978 > 0) {
                    jSONObject.put("8", m2978);
                }
                int m2979 = this.f134.m297(m296, JSONObject.class, "toString", new Object[0]);
                if (m2979 > 0) {
                    jSONObject.put("9", m2979);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
