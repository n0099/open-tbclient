package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f43700a;

    /* renamed from: a  reason: collision with other field name */
    public static String f985a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1664386142, "Lcom/xiaomi/push/t;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1664386142, "Lcom/xiaomi/push/t;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> a2 = a(null, "miui.os.Build");
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
    public static Context m636a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f43700a : (Context) invokeV.objValue;
    }

    public static Class<?> a(Context context, String str) {
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
                } catch (ClassNotFoundException unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", e2);
            }
        }
        return (Class) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m637a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (t.class) {
                if (f985a != null) {
                    return f985a;
                }
                String str = Build.VERSION.INCREMENTAL;
                if (a() <= 0) {
                    String b2 = b();
                    if (TextUtils.isEmpty(b2)) {
                        b2 = c();
                        if (TextUtils.isEmpty(b2)) {
                            b2 = d();
                            if (TextUtils.isEmpty(b2)) {
                                str = String.valueOf(s.a("ro.product.brand", "Android") + "_" + str);
                            }
                        }
                    }
                    str = b2;
                }
                f985a = str;
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (l.m538b()) {
                return "";
            }
            String str = (String) bh.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
            return TextUtils.isEmpty(str) ? "0" : str;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m638a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            f43700a = context.getApplicationContext();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m639a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TextUtils.equals((String) bh.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1") : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m640a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return (context.getApplicationInfo().flags & 2) != 0;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String a2 = s.a("ro.build.version.emui", "");
            f985a = a2;
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m641b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
            } catch (ClassNotFoundException unused) {
                com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
                return false;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String a2 = s.a("ro.build.version.opporom", "");
            if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
                f985a = "ColorOS_" + a2;
            }
            return f985a;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String a2 = s.a("ro.vivo.os.version", "");
            if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
                f985a = "FuntouchOS_" + a2;
            }
            return f985a;
        }
        return (String) invokeV.objValue;
    }
}
