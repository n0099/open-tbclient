package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f41273a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, o> f816a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f41274b = -1;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        int i;
        boolean z;
        if (f41273a == 0) {
            try {
                i = 1;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                f41273a = 0;
            }
            if (TextUtils.isEmpty(m518a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m518a("ro.miui.ui.version.name"))) {
                z = false;
                if (z) {
                    i = 2;
                }
                f41273a = i;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f41273a);
            }
            z = true;
            if (z) {
            }
            f41273a = i;
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f41273a);
        }
        return f41273a;
    }

    public static int a(Context context) {
        String m518a = m518a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m518a) || !TextUtils.isDigitsOnly(m518a)) {
            return 0;
        }
        return Integer.parseInt(m518a);
    }

    public static o a(String str) {
        o b2 = b(str);
        return b2 == null ? o.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m517a() {
        int a2 = t.a();
        return (!m520a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m518a(String str) {
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

    /* renamed from: a  reason: collision with other method in class */
    public static void m519a() {
        if (f816a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f816a = hashMap;
        hashMap.put("CN", o.China);
        f816a.put("FI", o.Europe);
        f816a.put("SE", o.Europe);
        f816a.put("NO", o.Europe);
        f816a.put("FO", o.Europe);
        f816a.put("EE", o.Europe);
        f816a.put("LV", o.Europe);
        f816a.put("LT", o.Europe);
        f816a.put("BY", o.Europe);
        f816a.put("MD", o.Europe);
        f816a.put("UA", o.Europe);
        f816a.put("PL", o.Europe);
        f816a.put("CZ", o.Europe);
        f816a.put("SK", o.Europe);
        f816a.put("HU", o.Europe);
        f816a.put("DE", o.Europe);
        f816a.put("AT", o.Europe);
        f816a.put("CH", o.Europe);
        f816a.put("LI", o.Europe);
        f816a.put("GB", o.Europe);
        f816a.put("IE", o.Europe);
        f816a.put("NL", o.Europe);
        f816a.put("BE", o.Europe);
        f816a.put("LU", o.Europe);
        f816a.put("FR", o.Europe);
        f816a.put("RO", o.Europe);
        f816a.put("BG", o.Europe);
        f816a.put("RS", o.Europe);
        f816a.put("MK", o.Europe);
        f816a.put("AL", o.Europe);
        f816a.put("GR", o.Europe);
        f816a.put("SI", o.Europe);
        f816a.put("HR", o.Europe);
        f816a.put("IT", o.Europe);
        f816a.put("SM", o.Europe);
        f816a.put("MT", o.Europe);
        f816a.put("ES", o.Europe);
        f816a.put("PT", o.Europe);
        f816a.put("AD", o.Europe);
        f816a.put("CY", o.Europe);
        f816a.put("DK", o.Europe);
        f816a.put("RU", o.Russia);
        f816a.put("IN", o.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m520a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m521a(Context context) {
        return context != null && m522a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m522a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static o b(String str) {
        m519a();
        return f816a.get(str.toUpperCase());
    }

    public static String b() {
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
            com.xiaomi.channel.commonutils.logger.b.m55a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m55a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m523b() {
        return a() == 2;
    }

    public static boolean c() {
        if (f41274b < 0) {
            Object a2 = bh.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            f41274b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                f41274b = 1;
            }
        }
        return f41274b > 0;
    }

    public static boolean d() {
        return !o.China.name().equalsIgnoreCase(a(b()).name());
    }
}
