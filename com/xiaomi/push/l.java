package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f43516a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, o> f819a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f43517b = -1;
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
            if (f43516a == 0) {
                try {
                    i2 = 1;
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                    f43516a = 0;
                }
                if (TextUtils.isEmpty(m533a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m533a("ro.miui.ui.version.name"))) {
                    z = false;
                    if (z) {
                        i2 = 2;
                    }
                    f43516a = i2;
                    com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f43516a);
                }
                z = true;
                if (z) {
                }
                f43516a = i2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f43516a);
            }
            return f43516a;
        }
        return invokeV.intValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String m533a = m533a("ro.miui.ui.version.code");
            if (TextUtils.isEmpty(m533a) || !TextUtils.isDigitsOnly(m533a)) {
                return 0;
            }
            return Integer.parseInt(m533a);
        }
        return invokeL.intValue;
    }

    public static o a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            o b2 = b(str);
            return b2 == null ? o.f43519b : b2;
        }
        return (o) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m532a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            int a2 = t.a();
            return (!m535a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m533a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
    public static void m534a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) && f819a == null) {
            HashMap hashMap = new HashMap();
            f819a = hashMap;
            hashMap.put("CN", o.f43518a);
            f819a.put("FI", o.f43520c);
            f819a.put("SE", o.f43520c);
            f819a.put("NO", o.f43520c);
            f819a.put("FO", o.f43520c);
            f819a.put("EE", o.f43520c);
            f819a.put("LV", o.f43520c);
            f819a.put("LT", o.f43520c);
            f819a.put("BY", o.f43520c);
            f819a.put("MD", o.f43520c);
            f819a.put("UA", o.f43520c);
            f819a.put("PL", o.f43520c);
            f819a.put("CZ", o.f43520c);
            f819a.put("SK", o.f43520c);
            f819a.put("HU", o.f43520c);
            f819a.put("DE", o.f43520c);
            f819a.put("AT", o.f43520c);
            f819a.put("CH", o.f43520c);
            f819a.put("LI", o.f43520c);
            f819a.put("GB", o.f43520c);
            f819a.put("IE", o.f43520c);
            f819a.put("NL", o.f43520c);
            f819a.put("BE", o.f43520c);
            f819a.put("LU", o.f43520c);
            f819a.put("FR", o.f43520c);
            f819a.put("RO", o.f43520c);
            f819a.put("BG", o.f43520c);
            f819a.put("RS", o.f43520c);
            f819a.put("MK", o.f43520c);
            f819a.put("AL", o.f43520c);
            f819a.put("GR", o.f43520c);
            f819a.put("SI", o.f43520c);
            f819a.put("HR", o.f43520c);
            f819a.put("IT", o.f43520c);
            f819a.put("SM", o.f43520c);
            f819a.put("MT", o.f43520c);
            f819a.put("ES", o.f43520c);
            f819a.put("PT", o.f43520c);
            f819a.put("AD", o.f43520c);
            f819a.put("CY", o.f43520c);
            f819a.put("DK", o.f43520c);
            f819a.put("RU", o.f43521d);
            f819a.put("IN", o.f43522e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m535a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m536a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context != null && m537a(context.getPackageName()) : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m537a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? "com.xiaomi.xmsf".equals(str) : invokeL.booleanValue;
    }

    public static o b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            m534a();
            return f819a.get(str.toUpperCase());
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
                com.xiaomi.channel.commonutils.logger.b.m70a("get region from system, region = " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                String country = Locale.getDefault().getCountry();
                com.xiaomi.channel.commonutils.logger.b.m70a("locale.default.country = " + country);
                return country;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m538b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a() == 2 : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f43517b < 0) {
                Object a2 = bh.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
                f43517b = 0;
                if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                    f43517b = 1;
                }
            }
            return f43517b > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? !o.f43518a.name().equalsIgnoreCase(a(b()).name()) : invokeV.booleanValue;
    }
}
