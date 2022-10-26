package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static String f1013a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1664386080, "Lcom/xiaomi/push/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1664386080, "Lcom/xiaomi/push/v;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class a2 = a(null, "miui.os.Build");
                if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                    return 3;
                }
                return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m687a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Context) invokeV.objValue;
    }

    public static Class a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (str == null || str.trim().length() == 0) {
                throw new ClassNotFoundException("class is empty");
            }
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m89a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        return (Class) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m688a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (v.class) {
                if (f1013a != null) {
                    return f1013a;
                }
                String str = Build.VERSION.INCREMENTAL;
                if (a() <= 0) {
                    String b = b();
                    if (TextUtils.isEmpty(b)) {
                        b = c();
                        if (TextUtils.isEmpty(b)) {
                            b = d();
                            if (TextUtils.isEmpty(b)) {
                                str = String.valueOf(u.a("ro.product.brand", "Android") + "_" + str);
                            }
                        }
                    }
                    str = b;
                }
                f1013a = str;
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            a = context.getApplicationContext();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m689a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? TextUtils.equals((String) bk.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1") : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m690a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return (context.getApplicationInfo().flags & 2) != 0;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String a2 = u.a("ro.build.version.emui", "");
            f1013a = a2;
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m691b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
            } catch (ClassNotFoundException unused) {
                com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
                return false;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String a2 = u.a("ro.build.version.opporom", "");
            if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
                f1013a = "ColorOS_" + a2;
            }
            return f1013a;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String a2 = u.a("ro.vivo.os.version", "");
            if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
                f1013a = "FuntouchOS_" + a2;
            }
            return f1013a;
        }
        return (String) invokeV.objValue;
    }
}
