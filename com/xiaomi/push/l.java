package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, o> f824a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f61443b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1664386390, "Lcom/xiaomi/push/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1664386390, "Lcom/xiaomi/push/l;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        InterceptResult invokeV;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == 0) {
                try {
                    i2 = 1;
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                    a = 0;
                }
                if (TextUtils.isEmpty(m597a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m597a("ro.miui.ui.version.name"))) {
                    z = false;
                    if (z) {
                        i2 = 2;
                    }
                    a = i2;
                    com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
                }
                z = true;
                if (z) {
                }
                a = i2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String m597a = m597a("ro.miui.ui.version.code");
            if (TextUtils.isEmpty(m597a) || !TextUtils.isDigitsOnly(m597a)) {
                return 0;
            }
            return Integer.parseInt(m597a);
        }
        return invokeL.intValue;
    }

    public static o a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            o b2 = b(str);
            return b2 == null ? o.f61444b : b2;
        }
        return (o) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m596a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int a2 = t.a();
            return (!m599a() || a2 <= 0) ? "" : a2 < 2 ? AnimationProperty.OPACITY : a2 < 3 ? "development" : "stable";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m597a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                try {
                    return (String) bh.a("android.os.SystemProperties", "get", str, "");
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e2);
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m598a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, null) == null) && f824a == null) {
            HashMap hashMap = new HashMap();
            f824a = hashMap;
            hashMap.put("CN", o.a);
            f824a.put("FI", o.f61445c);
            f824a.put("SE", o.f61445c);
            f824a.put("NO", o.f61445c);
            f824a.put("FO", o.f61445c);
            f824a.put("EE", o.f61445c);
            f824a.put("LV", o.f61445c);
            f824a.put("LT", o.f61445c);
            f824a.put("BY", o.f61445c);
            f824a.put("MD", o.f61445c);
            f824a.put("UA", o.f61445c);
            f824a.put("PL", o.f61445c);
            f824a.put("CZ", o.f61445c);
            f824a.put("SK", o.f61445c);
            f824a.put("HU", o.f61445c);
            f824a.put("DE", o.f61445c);
            f824a.put("AT", o.f61445c);
            f824a.put("CH", o.f61445c);
            f824a.put("LI", o.f61445c);
            f824a.put("GB", o.f61445c);
            f824a.put("IE", o.f61445c);
            f824a.put("NL", o.f61445c);
            f824a.put("BE", o.f61445c);
            f824a.put("LU", o.f61445c);
            f824a.put("FR", o.f61445c);
            f824a.put("RO", o.f61445c);
            f824a.put("BG", o.f61445c);
            f824a.put("RS", o.f61445c);
            f824a.put("MK", o.f61445c);
            f824a.put("AL", o.f61445c);
            f824a.put("GR", o.f61445c);
            f824a.put("SI", o.f61445c);
            f824a.put("HR", o.f61445c);
            f824a.put("IT", o.f61445c);
            f824a.put("SM", o.f61445c);
            f824a.put("MT", o.f61445c);
            f824a.put("ES", o.f61445c);
            f824a.put("PT", o.f61445c);
            f824a.put("AD", o.f61445c);
            f824a.put("CY", o.f61445c);
            f824a.put("DK", o.f61445c);
            f824a.put("RU", o.f61446d);
            f824a.put("IN", o.f61447e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m599a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m600a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context != null && m601a(context.getPackageName()) : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m601a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? "com.xiaomi.xmsf".equals(str) : invokeL.booleanValue;
    }

    public static o b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            m598a();
            return f824a.get(str.toUpperCase());
        }
        return (o) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String a2 = s.a("ro.miui.region", "");
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("persist.sys.oppo.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("ro.oppo.regionmark", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("ro.hw.country", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("ro.csc.countryiso_code", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("ro.product.country.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("gsm.vivo.countrycode", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("persist.sys.oem.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("ro.product.locale.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = s.a("persist.sys.country", "");
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m134a("get region from system, region = " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                String country = Locale.getDefault().getCountry();
                com.xiaomi.channel.commonutils.logger.b.m134a("locale.default.country = " + country);
                return country;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m602b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a() == 2 : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f61443b < 0) {
                Object a2 = bh.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
                f61443b = 0;
                if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                    f61443b = 1;
                }
            }
            return f61443b > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? !o.a.name().equalsIgnoreCase(a(b()).name()) : invokeV.booleanValue;
    }
}
