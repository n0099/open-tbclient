package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static Method e;
    public static String f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178418, "Lcom/vivo/push/util/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178418, "Lcom/vivo/push/util/j;");
                return;
            }
        }
        a = b("rom_1.0");
        b = b("rom_2.0");
        c = b("rom_2.5");
        d = b("rom_3.0");
        f = null;
        g = null;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (j.class) {
                if (f == null && g == null) {
                    try {
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                        e = declaredMethod;
                        declaredMethod.setAccessible(true);
                        f = (String) e.invoke(null, "ro.vivo.rom", "@><@");
                        g = (String) e.invoke(null, "ro.vivo.rom.version", "@><@");
                    } catch (Exception unused) {
                        p.b("Device", "getRomCode error");
                    }
                }
                p.d("Device", "sRomProperty1 : " + f + " ; sRomProperty2 : " + g);
                String a2 = a(f);
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
                String a3 = a(g);
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                return a3;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
            if (!matcher.find()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            if (TextUtils.isEmpty(matcher.group(2))) {
                substring = "0";
            } else {
                substring = matcher.group(2).substring(0, 1);
            }
            sb.append(substring);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String b2 = z.b("ro.vivo.rom", "");
            String b3 = z.b("ro.vivo.rom.version", "");
            p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
            if (b2 == null || !b2.contains(str)) {
                if (b3 != null && b3.contains(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String a(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = str2;
            }
            if (str3 != null && str3.length() != 0) {
                return str3;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                p.d("Device", "Build.MANUFACTURER is null");
                return false;
            }
            p.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
            if (!Build.MANUFACTURER.toLowerCase().contains("bbk") && !Build.MANUFACTURER.toLowerCase().startsWith("vivo")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
