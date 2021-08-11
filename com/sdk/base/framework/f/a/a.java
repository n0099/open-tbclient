package com.sdk.base.framework.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Stack;
/* loaded from: classes10.dex */
public class a extends com.sdk.base.framework.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75189a = "com.sdk.base.framework.f.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f75190b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065713969, "Lcom/sdk/base/framework/f/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065713969, "Lcom/sdk/base/framework/f/a/a;");
                return;
            }
        }
        f75190b = f.f75169b;
        new Stack();
    }

    public a() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
            } catch (SocketException unused) {
                return StringUtil.NULL_STRING;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
                return null;
            } catch (Exception e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            String str2 = (String) b(context, str);
            return c.a(str2).booleanValue() ? com.sdk.base.framework.f.b.a.a(context, Constants.API_KEY) : str2;
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                return Build.VERSION.SDK_INT;
            } catch (Exception e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (context == null) {
                return -1;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 1);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (Exception e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static <T> T b(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context == null || c.a(str).booleanValue()) {
                return null;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c(context), 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    return null;
                }
                return (T) bundle.get(str);
            } catch (Exception e2) {
                c.a(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                c.c(f75189a, "mContext 为空", Boolean.valueOf(f75190b));
                return null;
            }
            try {
                return context.getPackageName();
            } catch (Exception e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                com.sdk.base.framework.f.a.a(f75189a, "getAppLable", "mContext 为空", f75190b);
                return null;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            } catch (Exception e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException e2) {
                c.b(f75189a, e2.getMessage(), Boolean.valueOf(f75190b));
                packageInfo = null;
            }
            if (packageInfo != null) {
                int i2 = packageInfo.applicationInfo.flags;
                try {
                    byte[] byteArray = packageInfo.signatures[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(byteArray);
                    byte[] digest = messageDigest.digest();
                    String str = "";
                    for (int i3 = 0; i3 < digest.length; i3++) {
                        if (i3 != 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(":");
                            str = sb.toString();
                        }
                        String hexString = Integer.toHexString(digest[i3] & 255);
                        if (hexString.length() == 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append("0");
                            str = sb2.toString();
                        }
                        str = str + hexString;
                    }
                    return str;
                } catch (Exception e3) {
                    c.b(f75189a, e3.getMessage(), Boolean.valueOf(f75190b));
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
