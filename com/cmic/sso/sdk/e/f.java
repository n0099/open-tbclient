package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String str = null;
            try {
                PackageManager packageManager = context.getPackageManager();
                String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(d(context), 0));
                if (str2 != null) {
                    return str2;
                }
                try {
                    PackageInfo c = c(context);
                    if (c == null) {
                        return null;
                    }
                    return context.getResources().getString(c.applicationInfo.labelRes);
                } catch (Exception e) {
                    e = e;
                    str = str2;
                    e.printStackTrace();
                    return str;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                PackageInfo c = c(context);
                if (c != null) {
                    return d(context) + "&" + c.versionName;
                }
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static PackageInfo c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            PackageInfo c = c(context);
            if (c == null) {
                return "";
            }
            return c.packageName;
        }
        return (String) invokeL.objValue;
    }
}
