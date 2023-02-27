package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class PackageManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PackageUtils";
    public static final String VERSION = "5.0.10.302";
    public static String sAppVersion = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1044568078, "Lcom/huawei/hms/framework/common/PackageManagerCompat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1044568078, "Lcom/huawei/hms/framework/common/PackageManagerCompat;");
        }
    }

    public PackageManagerCompat() {
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

    public static String getAppPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (ContextHolder.getAppContext() != null) {
                context = ContextHolder.getAppContext();
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                Logger.w("PackageUtils", "Failed to get Package managers Package Info");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Bundle getBundleFromKit(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (ContextHolder.getKitContext() != null) {
                context = ContextHolder.getKitContext();
            }
            if (context == null) {
                Logger.v("PackageUtils", "the kitContext is null");
                return Bundle.EMPTY;
            } else if (context.getApplicationInfo() == null) {
                Logger.v("PackageUtils", "the kit applicationInfo is null");
                return Bundle.EMPTY;
            } else {
                Bundle bundle = context.getApplicationInfo().metaData;
                if (bundle == null) {
                    return Bundle.EMPTY;
                }
                return bundle;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static String getAppVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (!TextUtils.isEmpty(sAppVersion)) {
                return sAppVersion;
            }
            if (ContextHolder.getAppContext() != null) {
                context = ContextHolder.getAppContext();
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return sAppVersion;
            }
            try {
                sAppVersion = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            }
            return sAppVersion;
        }
        return (String) invokeL.objValue;
    }

    public static Bundle getBundleFromApp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Bundle bundle = Bundle.EMPTY;
            if (ContextHolder.getAppContext() != null) {
                context = ContextHolder.getAppContext();
            }
            if (context == null) {
                return bundle;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return bundle;
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    return applicationInfo.metaData;
                }
                return bundle;
            } catch (PackageManager.NameNotFoundException | RuntimeException e) {
                Logger.w("PackageUtils", "NameNotFoundException:", e);
                return bundle;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle getBundleFromKitOrAPP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            Bundle bundleFromKit = getBundleFromKit(context);
            if (bundleFromKit == null || bundleFromKit.isEmpty()) {
                return getBundleFromApp(context);
            }
            return bundleFromKit;
        }
        return (Bundle) invokeL.objValue;
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            Bundle bundleFromApp = getBundleFromApp(context);
            if (bundleFromApp != null) {
                return bundleFromApp.getString(str, str2);
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) {
            try {
                Bundle bundleFromKit = getBundleFromKit(context);
                if (bundleFromKit == null) {
                    return str2;
                }
                return bundleFromKit.getString(str, str2);
            } catch (RuntimeException unused) {
                Logger.v("PackageUtils", "the kit metaData is runtimeException");
                return str2;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, str, str2)) == null) {
            return getBundleFromKitOrAPP(context).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            HashMap hashMap = new HashMap();
            Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
            for (String str2 : getBundleFromKitOrAPP(context).keySet()) {
                if (str2.startsWith(str)) {
                    String string = bundleFromKitOrAPP.getString(str2);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str2.substring(str.length()), string);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
