package com.sdk.base.module.manager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.a.a;
/* loaded from: classes8.dex */
public abstract class SDKManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean closePermission = false;
    public static boolean isStrong = true;
    public static Context mContext = null;
    public static boolean smartTrust = true;
    public static String statisticalTestHost = "";
    public static String testHost = "";
    public static boolean useCache = true;
    public static String userAgent;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-223312462, "Lcom/sdk/base/module/manager/SDKManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-223312462, "Lcom/sdk/base/module/manager/SDKManager;");
        }
    }

    public SDKManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void closePermission(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            closePermission = z;
        }
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mContext : (Context) invokeV.objValue;
    }

    public static String getStatisticalTestHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? statisticalTestHost : (String) invokeV.objValue;
    }

    public static String getTestHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? testHost : (String) invokeV.objValue;
    }

    public static String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? userAgent : (String) invokeV.objValue;
    }

    public static void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            mContext = context;
            a a = a.a(context);
            com.sdk.base.framework.f.a.a.c();
            a.a(null, str);
        }
    }

    public static void init(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, str, str2) == null) {
            mContext = context;
            a a = a.a(context);
            com.sdk.base.framework.f.a.a.c();
            a.a(str, str2);
        }
    }

    public static boolean isClosePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? closePermission : invokeV.booleanValue;
    }

    public static boolean isIsStrong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? isStrong : invokeV.booleanValue;
    }

    public static boolean isSmartTrust() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? smartTrust : invokeV.booleanValue;
    }

    public static void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f.f57798b = z;
        }
    }

    public static void setDebugHead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            f.f57800d = z;
        }
    }

    public static void setIsStrong(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            isStrong = z;
        }
    }

    public static void setSmartTrust(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            smartTrust = z;
        }
    }

    public static void setStatisticalTestHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            statisticalTestHost = str;
        }
    }

    public static void setTestHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            testHost = str;
        }
    }

    public static void setUseCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            useCache = z;
        }
    }

    public static void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            userAgent = str;
        }
    }

    public static <T> void toFailed(CallBack<T> callBack, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65556, null, callBack, i2, str) == null) || callBack == null) {
            return;
        }
        callBack.onFailed(1, i2, str, null);
    }

    public static boolean useCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? useCache : invokeV.booleanValue;
    }
}
