package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;
/* loaded from: classes9.dex */
public class BaseUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseUtils() {
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

    public static void clearSubjectIds(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            i.a(context).removeKey("subjectId");
        }
    }

    public static void deleteAllTokenCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            i.a(context).a();
        }
    }

    public static boolean getProxyInit(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return i.a(context).getBoolean("_proxy_init");
        }
        return invokeL.booleanValue;
    }

    public static String[] getSubjectIds(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String string = i.a(context).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                return new String[0];
            }
            return string.split(",");
        }
        return (String[]) invokeL.objValue;
    }

    public static void initSecret(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            b.a(context);
        }
    }

    public static void delLocalToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            i.a(context).c(str);
        }
    }

    public static void deleteCacheData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            i.a(context).removeKey(str);
        }
    }

    public static String getLocalToken(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            return i.a(context).b(str);
        }
        return (String) invokeLL.objValue;
    }

    public static void reportAaidToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            n.a(context, str);
        }
    }

    public static void saveProxyInit(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, context, z) == null) {
            i.a(context).saveBoolean("_proxy_init", z);
        }
    }

    public static String getBaseUrl(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, context, str, str2, str3, str4)) == null) {
            return e.a(context, str, str2, str3, str4);
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String getCacheData(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, context, str, z)) == null) {
            if (z) {
                return i.a(context).a(str);
            }
            return i.a(context).getString(str);
        }
        return (String) invokeLLZ.objValue;
    }

    public static void saveToken(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, str2) == null) {
            i.a(context).b(str, str2);
        }
    }

    public static boolean isMainProc(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String a = p.a(context);
            String str = context.getApplicationInfo().processName;
            HMSLog.i("BaseUtils", "main process name: " + str + ", current process name: " + a);
            return str.equals(a);
        }
        return invokeL.booleanValue;
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            if (z) {
                return i.a(context).a(str, str2);
            }
            return i.a(context).saveString(str, str2);
        }
        return invokeCommon.booleanValue;
    }

    public static String sendPostRequest(Context context, String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, context, str, str2, map)) == null) {
            return d.a(context, str, str2, map);
        }
        return (String) invokeLLLL.objValue;
    }
}
