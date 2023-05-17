package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
/* loaded from: classes9.dex */
public class SystemUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SystemUtils() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return getSystemProperties(CountryCodeBean.LOCALE_COUNTRYSYSTEMPROP, "");
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return getSystemProperties(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        }
        return (String) invokeV.objValue;
    }

    public static String getLocalCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Locale locale = Locale.getDefault();
            if (locale != null) {
                return locale.getCountry();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean isTVDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase(Config.TARGET_SDK_VERSION);
        }
        return invokeV.booleanValue;
    }

    public static String getNetType(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return activeNetworkInfo.getTypeName();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getSystemProperties(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(cls, str, str2);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
                HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isSystemApp(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (PackageManager.NameNotFoundException e) {
                HMSLog.e("SystemUtils", "isSystemApp Exception: " + e);
                packageInfo = null;
                if (packageInfo == null) {
                }
                return false;
            } catch (RuntimeException e2) {
                HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e2);
                packageInfo = null;
                if (packageInfo == null) {
                }
                return false;
            }
            if (packageInfo == null && (packageInfo.applicationInfo.flags & 1) > 0) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isChinaROM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String b = b();
            if (!TextUtils.isEmpty(b)) {
                return "cn".equalsIgnoreCase(b);
            }
            String a = a();
            if (!TextUtils.isEmpty(a)) {
                return a.toLowerCase(Locale.US).contains("cn");
            }
            String localCountry = getLocalCountry();
            if (!TextUtils.isEmpty(localCountry)) {
                return "cn".equalsIgnoreCase(localCountry);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isEMUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HMSLog.i("SystemUtils", "is Emui :" + HwBuildEx.VERSION.EMUI_SDK_INT);
            if (HwBuildEx.VERSION.EMUI_SDK_INT > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
