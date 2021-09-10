package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f76684a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f76685b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f76686c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f76687d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f76688e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f76689f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f76690g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f76691h;

    /* renamed from: i  reason: collision with root package name */
    public static Method f76692i;

    /* renamed from: j  reason: collision with root package name */
    public static String f76693j;
    public static String k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        String b2;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178449, "Lcom/vivo/push/util/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178449, "Lcom/vivo/push/util/k;");
                return;
            }
        }
        f76684a = z.b("ro.vivo.product.overseas", "no").equals("yes");
        if (Build.VERSION.SDK_INT >= 26) {
            b2 = z.b("ro.product.country.region", "N");
        } else {
            b2 = z.b("ro.product.customize.bbk", "N");
        }
        f76685b = b2;
        f76686c = "RU".equals(b2);
        f76687d = "IN".equals(f76685b);
        f76688e = b("rom_1.0");
        f76689f = b("rom_2.0");
        f76690g = b("rom_2.5");
        f76691h = b("rom_3.0");
        f76693j = null;
        k = null;
        l = "";
        m = "";
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (k.class) {
                if (f76693j == null && k == null) {
                    try {
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                        f76692i = declaredMethod;
                        declaredMethod.setAccessible(true);
                        f76693j = (String) f76692i.invoke(null, "ro.vivo.rom", "@><@");
                        k = (String) f76692i.invoke(null, "ro.vivo.rom.version", "@><@");
                    } catch (Exception unused) {
                        p.b("Device", "getRomCode error");
                    }
                }
                p.d("Device", "sRomProperty1 : " + f76693j + " ; sRomProperty2 : " + k);
                String a2 = a(f76693j);
                if (TextUtils.isEmpty(a2)) {
                    String a3 = a(k);
                    if (TextUtils.isEmpty(a3)) {
                        return null;
                    }
                    return a3;
                }
                return a2;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String b2 = z.b("ro.vivo.rom", "");
            String b3 = z.b("ro.vivo.rom.version", "");
            p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
            if (b2 == null || !b2.contains(str)) {
                return b3 != null && b3.contains(str);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                p.d("Device", "Build.MANUFACTURER is null");
                return false;
            }
            p.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
            return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_VIVO);
        }
        return invokeV.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                sb.append(matcher.group(1));
                sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
