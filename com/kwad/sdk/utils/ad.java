package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class ad {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f74195a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f74196b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f74197c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734111, "Lcom/kwad/sdk/utils/ad;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734111, "Lcom/kwad/sdk/utils/ad;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f74196b = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        f74196b.add("android.permission.WRITE_SETTINGS");
        f74196b.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (f74195a == null) {
                try {
                    a(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (!f74196b.contains(str) || (b2 = b(context, str)) == -2) {
                int c2 = c(context, str);
                return c2 != -2 ? c2 : context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            return b2;
        }
        return invokeLL.intValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf < 0) {
                return str;
            }
            try {
                return str.substring(lastIndexOf + 1);
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, strArr) == null) || Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        f74195a = new HashMap();
        for (String str : strArr) {
            try {
                Field declaredField = AppOpsManager.class.getDeclaredField("OP_" + a(str));
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(null)).intValue();
                if (intValue >= 0) {
                    f74195a.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                i2 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
            } catch (Throwable unused) {
                i2 = 0;
            }
            return i2 == 1;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -2078357533) {
                if (str.equals("android.permission.WRITE_SETTINGS")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != -1561629405) {
                if (hashCode == 1777263169 && str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                if (Build.VERSION.SDK_INT >= 26) {
                    if (context.getPackageManager().canRequestPackageInstalls()) {
                        return 0;
                    }
                }
                return -2;
            } else if (c2 != 1) {
                if (c2 == 2 && Build.VERSION.SDK_INT >= 23) {
                    return Settings.canDrawOverlays(context) ? 0 : -1;
                }
                return -2;
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.System.canWrite(context)) {
                        return 0;
                    }
                }
                return -2;
            }
        }
        return invokeLL.intValue;
    }

    public static int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            if (str == null) {
                return -2;
            }
            if (Build.VERSION.SDK_INT < 19) {
                return 0;
            }
            if (f74195a.containsKey(str)) {
                int intValue = f74195a.get(str).intValue();
                try {
                    if (f74197c == null) {
                        Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                        f74197c = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    return ((Integer) f74197c.invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(intValue), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return 0;
                }
            }
            return -2;
        }
        return invokeLL.intValue;
    }
}
