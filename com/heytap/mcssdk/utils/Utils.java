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
/* loaded from: classes3.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SDK_INT_26 = 26;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAppName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e2) {
                LogUtil.e(e2);
                return "app";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e2) {
                LogUtil.e(e2);
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getString(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 : iArr) {
                sb.append((char) i2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getSystemProperties(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (IllegalArgumentException e2) {
                throw e2;
            } catch (Exception unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int getVersionCode(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionCode;
            } catch (Exception e2) {
                LogUtil.d("getVersionCode--Exception:" + e2.getMessage());
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getVersionName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (Exception e2) {
                LogUtil.d("getVersionName--Exception:" + e2.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isExistPackage(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException e2) {
                LogUtil.e("isExistPackage NameNotFoundException:" + e2.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isSupportPush(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            } catch (PackageManager.NameNotFoundException e2) {
                LogUtil.e("isSupportPush NameNotFoundException:" + e2.getMessage());
                applicationInfo = null;
            }
            return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
        }
        return invokeLLL.booleanValue;
    }

    public static int parseInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e2) {
                    LogUtil.e("parseInt--NumberFormatException" + e2.getMessage());
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
