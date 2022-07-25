package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, q> f818a = null;
    public static int b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1664386359, "Lcom/xiaomi/push/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1664386359, "Lcom/xiaomi/push/m;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        InterceptResult invokeV;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == 0) {
                try {
                    i = 1;
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                    a = 0;
                }
                if (TextUtils.isEmpty(m558a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m558a("ro.miui.ui.version.name"))) {
                    z = false;
                    if (z) {
                        i = 2;
                    }
                    a = i;
                    com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
                }
                z = true;
                if (z) {
                }
                a = i;
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
            String m558a = m558a("ro.miui.ui.version.code");
            if (TextUtils.isEmpty(m558a) || !TextUtils.isDigitsOnly(m558a)) {
                return 0;
            }
            return Integer.parseInt(m558a);
        }
        return invokeL.intValue;
    }

    public static q a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            q b2 = b(str);
            return b2 == null ? q.b : b2;
        }
        return (q) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m557a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int a2 = v.a();
            return (!m560a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return (String) invokeV.objValue;
    }

    public static String a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, intent)) == null) {
            if (intent == null) {
                return null;
            }
            return intent.toString() + " " + a(intent.getExtras());
        }
        return (String) invokeL.objValue;
    }

    public static String a(Bundle bundle) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bundle)) == null) {
            StringBuilder sb = new StringBuilder("Bundle[");
            if (bundle == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                boolean z = true;
                for (String str : bundle.keySet()) {
                    if (!z) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb.append(str);
                    sb.append('=');
                    Object obj = bundle.get(str);
                    if (obj instanceof int[]) {
                        a2 = Arrays.toString((int[]) obj);
                    } else if (obj instanceof byte[]) {
                        a2 = Arrays.toString((byte[]) obj);
                    } else if (obj instanceof boolean[]) {
                        a2 = Arrays.toString((boolean[]) obj);
                    } else if (obj instanceof short[]) {
                        a2 = Arrays.toString((short[]) obj);
                    } else if (obj instanceof long[]) {
                        a2 = Arrays.toString((long[]) obj);
                    } else if (obj instanceof float[]) {
                        a2 = Arrays.toString((float[]) obj);
                    } else if (obj instanceof double[]) {
                        a2 = Arrays.toString((double[]) obj);
                    } else if (obj instanceof String[]) {
                        a2 = Arrays.toString((String[]) obj);
                    } else if (obj instanceof CharSequence[]) {
                        a2 = Arrays.toString((CharSequence[]) obj);
                    } else if (obj instanceof Parcelable[]) {
                        a2 = Arrays.toString((Parcelable[]) obj);
                    } else if (obj instanceof Bundle) {
                        a2 = a((Bundle) obj);
                    } else {
                        sb.append(obj);
                        z = false;
                    }
                    sb.append(a2);
                    z = false;
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m558a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                try {
                    return (String) bk.a("android.os.SystemProperties", "get", str, "");
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m559a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, null) == null) && f818a == null) {
            HashMap hashMap = new HashMap();
            f818a = hashMap;
            hashMap.put("CN", q.a);
            f818a.put("FI", q.c);
            f818a.put("SE", q.c);
            f818a.put(HlsPlaylistParser.BOOLEAN_FALSE, q.c);
            f818a.put("FO", q.c);
            f818a.put("EE", q.c);
            f818a.put("LV", q.c);
            f818a.put("LT", q.c);
            f818a.put("BY", q.c);
            f818a.put("MD", q.c);
            f818a.put("UA", q.c);
            f818a.put("PL", q.c);
            f818a.put("CZ", q.c);
            f818a.put("SK", q.c);
            f818a.put("HU", q.c);
            f818a.put("DE", q.c);
            f818a.put("AT", q.c);
            f818a.put("CH", q.c);
            f818a.put("LI", q.c);
            f818a.put("GB", q.c);
            f818a.put("IE", q.c);
            f818a.put("NL", q.c);
            f818a.put("BE", q.c);
            f818a.put("LU", q.c);
            f818a.put("FR", q.c);
            f818a.put("RO", q.c);
            f818a.put("BG", q.c);
            f818a.put("RS", q.c);
            f818a.put("MK", q.c);
            f818a.put("AL", q.c);
            f818a.put("GR", q.c);
            f818a.put("SI", q.c);
            f818a.put("HR", q.c);
            f818a.put("IT", q.c);
            f818a.put("SM", q.c);
            f818a.put("MT", q.c);
            f818a.put("ES", q.c);
            f818a.put("PT", q.c);
            f818a.put("AD", q.c);
            f818a.put("CY", q.c);
            f818a.put("DK", q.c);
            f818a.put("IS", q.c);
            f818a.put("UK", q.c);
            f818a.put("EL", q.c);
            f818a.put("RU", q.d);
            f818a.put("IN", q.e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m560a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m561a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? context != null && m562a(context.getPackageName()) : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m562a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? "com.xiaomi.xmsf".equals(str) : invokeL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static q b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            m559a();
            return f818a.get(str.toUpperCase());
        }
        return (q) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String a2 = u.a("ro.miui.region", "");
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("persist.sys.oppo.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("ro.oppo.regionmark", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("ro.vendor.oplus.regionmark", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("ro.hw.country", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("ro.csc.countryiso_code", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = m563b(u.a("ro.product.country.region", ""));
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("gsm.vivo.countrycode", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("persist.sys.oem.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("ro.product.locale.region", "");
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = u.a("persist.sys.country", "");
            }
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m89a("get region from system, region = " + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                String country = Locale.getDefault().getCountry();
                com.xiaomi.channel.commonutils.logger.b.m89a("locale.default.country = " + country);
                return country;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m563b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String[] split = str.split("-");
            return split.length > 0 ? split[0] : str;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m564b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? a() == 2 : invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? m558a("ro.miui.ui.version.name") : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m565c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (b < 0) {
                b = !m567e() ? 1 : 0;
            }
            return b > 0;
        }
        return invokeV.booleanValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? m558a("ro.build.characteristics") : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m566d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? !q.a.name().equalsIgnoreCase(a(b()).name()) : invokeV.booleanValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? m558a("ro.product.manufacturer") : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m567e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            String str = "";
            try {
                str = u.a("ro.miui.ui.version.code", "");
            } catch (Exception unused) {
            }
            return !TextUtils.isEmpty(str);
        }
        return invokeV.booleanValue;
    }
}
