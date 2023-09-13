package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
/* loaded from: classes10.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
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

    public static String getString(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : iArr) {
                sb.append((char) i);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e) {
                d.b("getVersionCode--Exception:" + e.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int getVersionCode(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionCode;
            } catch (Exception e) {
                d.b("getVersionCode--Exception:" + e.getMessage());
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                d.b("getVersionName--Exception:" + e.getMessage());
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getVersionName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (Exception e) {
                d.b("getVersionName--Exception:" + e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isExistPackage(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                d.e("isExistPackage NameNotFoundException:" + e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isSupportPush(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            } catch (PackageManager.NameNotFoundException e) {
                d.e("isSupportPush NameNotFoundException:" + e.getMessage());
                applicationInfo = null;
            }
            return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isSupportPushByClient(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? PushService.getInstance().isSupportPushByClient(context) : invokeL.booleanValue;
    }

    public static int parseInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    d.e("parseInt--NumberFormatException" + e.getMessage());
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
