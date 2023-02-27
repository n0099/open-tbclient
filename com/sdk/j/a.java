package com.sdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.f.f;
import java.security.MessageDigest;
import java.util.Stack;
/* loaded from: classes8.dex */
public class a extends com.sdk.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.j.a";
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593048178, "Lcom/sdk/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593048178, "Lcom/sdk/j/a;");
                return;
            }
        }
        b = f.a;
        new Stack();
    }

    @SuppressLint({"NewApi"})
    public static int a() {
        int i;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                i = Build.VERSION.SDK_INT;
            } catch (Exception e) {
                e = e;
                i = -1;
            }
            try {
                com.sdk.o.a.a("android ：", String.valueOf(i), Boolean.valueOf(b));
            } catch (Exception e2) {
                e = e2;
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                com.sdk.i.a.a(a, "getAppLable", "mContext 为空", b);
                return null;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            } catch (Exception e) {
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) {
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

    public static String b(Context context) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException e) {
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                packageInfo = null;
            }
            if (packageInfo != null) {
                int i = packageInfo.applicationInfo.flags;
                try {
                    return a(packageInfo.signatures[0].toByteArray(), "MD5");
                } catch (Exception e2) {
                    com.sdk.o.a.a(a, e2.getMessage(), Boolean.valueOf(b));
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context == null) {
                com.sdk.o.a.c(a, "mContext 为空", Boolean.valueOf(b));
                return null;
            }
            try {
                return context.getPackageName();
            } catch (Exception e) {
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return -1;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 1);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (Exception e) {
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
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
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Object obj;
        String str2;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context != null && !com.sdk.o.a.a(str).booleanValue()) {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(c(context), 128);
                } catch (Exception e) {
                    com.sdk.o.a.b(a, e.getMessage(), Boolean.valueOf(b));
                }
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    obj = bundle.get(str);
                    str2 = (String) obj;
                    if (!com.sdk.o.a.a(str2).booleanValue()) {
                        return com.sdk.v.a.c;
                    }
                    return str2;
                }
            }
            obj = null;
            str2 = (String) obj;
            if (!com.sdk.o.a.a(str2).booleanValue()) {
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }
}
