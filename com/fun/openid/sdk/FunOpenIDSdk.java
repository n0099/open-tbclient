package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FunOpenIDSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "1.3.8";
    public static final String TAG = "FunOpenIDSdk";
    public static boolean isRPSPermissionGranted;
    public static boolean logEnabled;
    public static String vivoAppId;
    public transient /* synthetic */ FieldHolder $fh;

    public FunOpenIDSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? DeviceUtils.getAndroidId(context) : (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? DeviceUtils.getImei(context) : (String) invokeL.objValue;
    }

    public static String getImeiNew(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? DeviceUtils.getImeiNew(context) : (String) invokeL.objValue;
    }

    public static String getMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? DeviceUtils.getMD5(str) : (String) invokeL.objValue;
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? SDK_VERSION : (String) invokeV.objValue;
    }

    public static String getVivoAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? vivoAppId : (String) invokeV.objValue;
    }

    public static boolean isIsRPSPermissionGranted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? isRPSPermissionGranted : invokeV.booleanValue;
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? logEnabled : invokeV.booleanValue;
    }

    public static void onRPSPermissionGranted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            isRPSPermissionGranted = true;
        }
    }

    public static void setLogEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            logEnabled = z;
        }
    }

    public static void setVivoAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            vivoAppId = str;
        }
    }

    public static synchronized void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, onGetOaidListener) == null) {
            synchronized (FunOpenIDSdk.class) {
                if (context == null) {
                    if (isLogEnabled()) {
                        Log.e(TAG, "getOaid context is null !!!");
                    }
                } else if (onGetOaidListener == null) {
                    if (isLogEnabled()) {
                        Log.e(TAG, "getOaid onGetOaidListener is null !!!");
                    }
                } else {
                    j.a.execute(new e(context, onGetOaidListener));
                }
            }
        }
    }
}
