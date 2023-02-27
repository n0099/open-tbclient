package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AndroidException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes8.dex */
public class Util {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AVAILABLE_LOADED = "availableLoaded";
    public static final Object LOCK_OBJECT;
    public static final String META_HMSVERSION_NAME = "com.huawei.hms.version";
    public static final String SERVICE_ACTION = "com.huawei.hms.core.internal";
    public static final String TAG = "Util";
    public static boolean availableInit;
    public static boolean isAvailableAvailable;
    public static String serviceAction;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2147261844, "Lcom/huawei/hms/utils/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2147261844, "Lcom/huawei/hms/utils/Util;");
                return;
            }
        }
        LOCK_OBJECT = new Object();
    }

    public Util() {
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

    public static boolean isChinaROM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return SystemUtils.isChinaROM();
        }
        return invokeV.booleanValue;
    }

    public static boolean isEMUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return SystemUtils.isEMUI();
        }
        return invokeV.booleanValue;
    }

    public static int compareHmsVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (TextUtils.isEmpty(str2)) {
                return 1;
            }
            if (StringUtil.checkVersion(str) && StringUtil.checkVersion(str2)) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (2 < split.length && 2 < split2.length) {
                    if (Integer.parseInt(split[0]) > Integer.parseInt(split2[0])) {
                        return 1;
                    }
                    if (Integer.parseInt(split[0]) < Integer.parseInt(split2[0])) {
                        return -1;
                    }
                    if (Integer.parseInt(split[1]) > Integer.parseInt(split2[1])) {
                        return 1;
                    }
                    if (Integer.parseInt(split[1]) < Integer.parseInt(split2[1])) {
                        return -1;
                    }
                    if (Integer.parseInt(split[2]) > Integer.parseInt(split2[2])) {
                        return 1;
                    }
                    if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, context)) == null) {
            return UIUtil.getActiveActivity(activity, context);
        }
        return (Activity) invokeLL.objValue;
    }

    public static String getProcessName(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            return UIUtil.getProcessName(context, i);
        }
        return (String) invokeLI.objValue;
    }

    public static String getSystemProperties(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            return SystemUtils.getSystemProperties(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static Activity getValidActivity(Activity activity, Activity activity2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, activity, activity2)) == null) {
            if (activity == null || activity.isFinishing()) {
                if (activity2 != null && !activity2.isFinishing()) {
                    return activity2;
                }
                return null;
            }
            return activity;
        }
        return (Activity) invokeLL.objValue;
    }

    public static String getAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return AGCUtils.getAppId(context);
        }
        return (String) invokeL.objValue;
    }

    public static String getCpId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return AGCUtils.getCpId(context);
        }
        return (String) invokeL.objValue;
    }

    public static String getNetType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return SystemUtils.getNetType(context);
        }
        return (String) invokeL.objValue;
    }

    public static String getAppName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (context == null) {
                HMSLog.e("Util", "In getAppName, context is null.");
                return "";
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
                return "";
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName();
                }
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
                if (applicationLabel == null) {
                    return "";
                }
                return applicationLabel.toString();
            } catch (Resources.NotFoundException | AndroidException unused) {
                HMSLog.e("Util", "In getAppName, Failed to get app name.");
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getHmsVersion(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
                return 0;
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get(META_HMSVERSION_NAME)) != null) {
                    String valueOf = String.valueOf(obj);
                    if (!TextUtils.isEmpty(valueOf)) {
                        return StringUtil.convertVersion2Integer(valueOf);
                    }
                }
                HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
                return 0;
            } catch (AndroidException unused) {
                HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
                return 0;
            } catch (RuntimeException e) {
                HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static String getProductCountry() {
        InterceptResult invokeV;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String systemProperties = getSystemProperties(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
            if (!TextUtils.isEmpty(systemProperties)) {
                return systemProperties;
            }
            String systemProperties2 = getSystemProperties(CountryCodeBean.LOCALE_COUNTRYSYSTEMPROP, "");
            if (!TextUtils.isEmpty(systemProperties2) && (lastIndexOf = systemProperties2.lastIndexOf("-")) != -1) {
                return systemProperties2.substring(lastIndexOf + 1);
            }
            String localCountry = SystemUtils.getLocalCountry();
            if (TextUtils.isEmpty(localCountry)) {
                return "";
            }
            return localCountry;
        }
        return (String) invokeV.objValue;
    }

    public static String getServiceActionMetadata(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String str = serviceAction;
            if (str != null) {
                return str;
            }
            Intent intent = new Intent("com.huawei.hms.core.internal");
            intent.setPackage(context.getPackageName());
            if (context.getPackageManager().resolveService(intent, 128) != null) {
                serviceAction = "com.huawei.hms.core.internal";
                return "com.huawei.hms.core.internal";
            }
            serviceAction = "";
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isAvailableLibExist(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            synchronized (LOCK_OBJECT) {
                if (!availableInit) {
                    boolean z = false;
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager == null) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                        try {
                            Class.forName("com.huawei.hms.adapter.AvailableAdapter");
                            z = true;
                        } catch (ClassNotFoundException unused) {
                            HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
                        }
                        isAvailableAvailable = z;
                        availableInit = true;
                    } else {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get(AVAILABLE_LOADED)) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                                HMSLog.i("Util", "available exist: true");
                                z = true;
                            }
                        } catch (AndroidException unused2) {
                            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                        } catch (RuntimeException e) {
                            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e);
                        }
                        isAvailableAvailable = z;
                        availableInit = true;
                    }
                }
            }
            HMSLog.i("Util", "available exist: " + isAvailableAvailable);
            return isAvailableAvailable;
        }
        return invokeL.booleanValue;
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, serviceConnection) == null) {
            try {
                HMSLog.i("Util", "Trying to unbind service from " + serviceConnection);
                context.unbindService(serviceConnection);
            } catch (Exception e) {
                HMSLog.e("Util", "On unBindServiceException:" + e.getMessage());
            }
        }
    }
}
