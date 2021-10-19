package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f78412a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, o> f823a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f78413b = -1;
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
            if (f78412a == 0) {
                try {
                    i2 = 1;
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                    f78412a = 0;
                }
                if (TextUtils.isEmpty(m536a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m536a("ro.miui.ui.version.name"))) {
                    z = false;
                    if (z) {
                        i2 = 2;
                    }
                    f78412a = i2;
                    com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f78412a);
                }
                z = true;
                if (z) {
                }
                f78412a = i2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f78412a);
            }
            return f78412a;
        }
        return invokeV.intValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String m536a = m536a("ro.miui.ui.version.code");
            if (TextUtils.isEmpty(m536a) || !TextUtils.isDigitsOnly(m536a)) {
                return 0;
            }
            return Integer.parseInt(m536a);
        }
        return invokeL.intValue;
    }

    public static o a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            o b2 = b(str);
            return b2 == null ? o.f78415b : b2;
        }
        return (o) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m535a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int a2 = t.a();
            return (!m538a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m536a(String str) {
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
    public static void m537a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) && f823a == null) {
            HashMap hashMap = new HashMap();
            f823a = hashMap;
            hashMap.put("CN", o.f78414a);
            f823a.put("FI", o.f78416c);
            f823a.put("SE", o.f78416c);
            f823a.put("NO", o.f78416c);
            f823a.put("FO", o.f78416c);
            f823a.put("EE", o.f78416c);
            f823a.put("LV", o.f78416c);
            f823a.put("LT", o.f78416c);
            f823a.put("BY", o.f78416c);
            f823a.put("MD", o.f78416c);
            f823a.put("UA", o.f78416c);
            f823a.put("PL", o.f78416c);
            f823a.put("CZ", o.f78416c);
            f823a.put("SK", o.f78416c);
            f823a.put("HU", o.f78416c);
            f823a.put("DE", o.f78416c);
            f823a.put("AT", o.f78416c);
            f823a.put("CH", o.f78416c);
            f823a.put("LI", o.f78416c);
            f823a.put("GB", o.f78416c);
            f823a.put("IE", o.f78416c);
            f823a.put("NL", o.f78416c);
            f823a.put("BE", o.f78416c);
            f823a.put("LU", o.f78416c);
            f823a.put("FR", o.f78416c);
            f823a.put("RO", o.f78416c);
            f823a.put("BG", o.f78416c);
            f823a.put("RS", o.f78416c);
            f823a.put("MK", o.f78416c);
            f823a.put("AL", o.f78416c);
            f823a.put("GR", o.f78416c);
            f823a.put("SI", o.f78416c);
            f823a.put("HR", o.f78416c);
            f823a.put("IT", o.f78416c);
            f823a.put("SM", o.f78416c);
            f823a.put("MT", o.f78416c);
            f823a.put("ES", o.f78416c);
            f823a.put("PT", o.f78416c);
            f823a.put("AD", o.f78416c);
            f823a.put("CY", o.f78416c);
            f823a.put("DK", o.f78416c);
            f823a.put("RU", o.f78417d);
            f823a.put("IN", o.f78418e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m538a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m539a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context != null && m540a(context.getPackageName()) : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m540a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? "com.xiaomi.xmsf".equals(str) : invokeL.booleanValue;
    }

    public static o b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            m537a();
            return f823a.get(str.toUpperCase());
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
                com.xiaomi.channel.commonutils.logger.b.m73a("get region from system, region = " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                String country = Locale.getDefault().getCountry();
                com.xiaomi.channel.commonutils.logger.b.m73a("locale.default.country = " + country);
                return country;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m541b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a() == 2 : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f78413b < 0) {
                Object a2 = bh.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
                f78413b = 0;
                if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                    f78413b = 1;
                }
            }
            return f78413b > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? !o.f78414a.name().equalsIgnoreCase(a(b()).name()) : invokeV.booleanValue;
    }
}
