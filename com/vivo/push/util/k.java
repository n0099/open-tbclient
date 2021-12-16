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
/* loaded from: classes4.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f63128b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f63129c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f63130d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f63131e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f63132f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f63133g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f63134h;

    /* renamed from: i  reason: collision with root package name */
    public static Method f63135i;

    /* renamed from: j  reason: collision with root package name */
    public static String f63136j;

    /* renamed from: k  reason: collision with root package name */
    public static String f63137k;
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
        a = z.b("ro.vivo.product.overseas", "no").equals("yes");
        if (Build.VERSION.SDK_INT >= 26) {
            b2 = z.b("ro.product.country.region", "N");
        } else {
            b2 = z.b("ro.product.customize.bbk", "N");
        }
        f63128b = b2;
        f63129c = "RU".equals(b2);
        f63130d = "IN".equals(f63128b);
        f63131e = b("rom_1.0");
        f63132f = b("rom_2.0");
        f63133g = b("rom_2.5");
        f63134h = b("rom_3.0");
        f63136j = null;
        f63137k = null;
        l = "";
        m = "";
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (k.class) {
                if (f63136j == null && f63137k == null) {
                    try {
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                        f63135i = declaredMethod;
                        declaredMethod.setAccessible(true);
                        f63136j = (String) f63135i.invoke(null, "ro.vivo.rom", "@><@");
                        f63137k = (String) f63135i.invoke(null, "ro.vivo.rom.version", "@><@");
                    } catch (Exception unused) {
                        p.b("Device", "getRomCode error");
                    }
                }
                p.d("Device", "sRomProperty1 : " + f63136j + " ; sRomProperty2 : " + f63137k);
                String a2 = a(f63136j);
                if (TextUtils.isEmpty(a2)) {
                    String a3 = a(f63137k);
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
