package com.sdk.base.framework.utils.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.f.g;
import com.sdk.i.a;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes8.dex */
public class AppUtils extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.sdk.base.framework.utils.app.AppUtils";
    public static Stack<Activity> activityStack;
    public static boolean isDebug;
    public static int targetSdkVersion;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1983098623, "Lcom/sdk/base/framework/utils/app/AppUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1983098623, "Lcom/sdk/base/framework/utils/app/AppUtils;");
                return;
            }
        }
        isDebug = g.b;
        activityStack = new Stack<>();
        targetSdkVersion = -1;
    }

    public AppUtils() {
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

    public static String doFingerprint(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            String str2 = "";
            for (int i = 0; i < digest.length; i++) {
                if (i != 0) {
                    str2 = str2 + ":";
                }
                String hexString = Integer.toHexString(digest[i] & 255);
                if (hexString.length() == 1) {
                    str2 = str2 + "0";
                }
                str2 = str2 + hexString;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int getAndroidSDKVersion(Context context) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                i = Build.VERSION.SDK_INT;
            } catch (Exception e) {
                e = e;
                i = -1;
            }
            try {
                com.sdk.n.a.a("android ：", String.valueOf(i), Boolean.valueOf(isDebug));
            } catch (Exception e2) {
                e = e2;
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return i;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String getApiKey(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            String str2 = (String) getMetaData(context, str);
            return com.sdk.n.a.a(str2).booleanValue() ? com.sdk.u.a.c : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static Drawable getAppIcon(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                a.logError(TAG, "getAppIcon", "mContext 为空", isDebug);
                return null;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    return context.getResources().getDrawable(packageInfo.applicationInfo.icon);
                }
                return null;
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static String getAppLable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context == null) {
                a.logError(TAG, "getAppLable", "mContext 为空", isDebug);
                return null;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getAppMd5(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                packageInfo = null;
            }
            if (packageInfo != null) {
                int i = packageInfo.applicationInfo.flags;
                try {
                    return doFingerprint(packageInfo.signatures[0].toByteArray(), "MD5");
                } catch (Exception e2) {
                    com.sdk.n.a.a(TAG, e2.getMessage(), Boolean.valueOf(isDebug));
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long getInstallDate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            Long b = com.sdk.j.a.b(context, g.a);
            if (b.longValue() == 0) {
                b = Long.valueOf(System.currentTimeMillis());
                com.sdk.j.a.a(context, g.a, b);
            }
            return b.longValue();
        }
        return invokeL.longValue;
    }

    public static String getLocalIPAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
                return StringUtil.NULL_STRING;
            } catch (Exception unused) {
                return StringUtil.NULL_STRING;
            }
        }
        return (String) invokeV.objValue;
    }

    public static <T> T getMetaData(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context == null || com.sdk.n.a.a(str).booleanValue()) {
                return null;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(getPackageName(context), 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    return null;
                }
                return (T) bundle.get(str);
            } catch (Exception e) {
                com.sdk.n.a.b(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentPackageName", new Class[0]);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, new Object[0]);
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context == null) {
                com.sdk.n.a.c(TAG, "mContext 为空", Boolean.valueOf(isDebug));
                return null;
            }
            try {
                return context.getPackageName();
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int getTargetSdkVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context == null) {
                return targetSdkVersion;
            }
            if (targetSdkVersion == -1) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getPackageName(context), 1);
                    if (packageInfo != null) {
                        targetSdkVersion = packageInfo.applicationInfo.targetSdkVersion;
                    }
                } catch (Exception e) {
                    com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                }
            }
            return targetSdkVersion;
        }
        return invokeL.intValue;
    }

    public static int getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null) {
                return -1;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getPackageName(context), 1);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
                return null;
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void addActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            activityStack.add(activity);
        }
    }

    public Activity currentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? activityStack.lastElement() : (Activity) invokeV.objValue;
    }

    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            finishActivity(activityStack.lastElement());
        }
    }

    public void finishActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || activity == null) {
            return;
        }
        activityStack.remove(activity);
        activity.finish();
    }

    public void finishActivity(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            Iterator<Activity> it = activityStack.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    finishActivity(next);
                }
            }
        }
    }

    public void finishAllActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i = 0; i < activityStack.size(); i++) {
                if (activityStack.get(i) != null) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }
}
