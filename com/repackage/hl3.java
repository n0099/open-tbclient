package com.repackage;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sofire.utility.PermissionChecker;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
@SuppressLint({"MissingPermission", "HardwareIds"})
/* loaded from: classes6.dex */
public class hl3 implements jl3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755644446, "Lcom/repackage/hl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755644446, "Lcom/repackage/hl3;");
                return;
            }
        }
        a = rg1.a;
    }

    public hl3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.jl3
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID) : (String) invokeL.objValue;
    }

    @Override // com.repackage.jl3
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // com.repackage.jl3
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    String meid = telephonyManager == null ? "" : telephonyManager.getMeid();
                    return TextUtils.isEmpty(meid) ? "" : meid;
                } catch (Exception e) {
                    hx1.o("DeviceInfoImpl", "getMeid: catch " + e + "\n" + Log.getStackTraceString(e));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.jl3
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (TextUtils.isEmpty(deviceId)) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            deviceId = telephonyManager.getImei();
                        }
                        return TextUtils.isEmpty(deviceId) ? "" : deviceId;
                    }
                    return deviceId;
                }
            } catch (Exception e) {
                hx1.o("DeviceInfoImpl", "getImei: catch " + e + "\n" + Log.getStackTraceString(e));
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.jl3
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (a) {
                    Log.d("DeviceInfoImpl", "android 29 can not get imei");
                }
                return "";
            }
            Application c = oj2.c();
            if (ContextCompat.checkSelfPermission(c, PermissionChecker.READ_PHONE_STATE) != 0) {
                return "";
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
                String deviceId = telephonyManager == null ? "" : telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
