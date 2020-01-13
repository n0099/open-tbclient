package com.xiaomi.push;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public class l {
    private static int a = 0;
    private static int b = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, o> f800a = null;

    public static synchronized int a() {
        int i;
        boolean z = false;
        synchronized (l.class) {
            if (a == 0) {
                if (!TextUtils.isEmpty(m476a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(m476a("ro.miui.ui.version.name"))) {
                    z = true;
                }
                a = z ? 1 : 2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            i = a;
        }
        return i;
    }

    public static o a(String str) {
        o b2 = b(str);
        return b2 == null ? o.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m475a() {
        String str;
        synchronized (l.class) {
            int a2 = t.a();
            str = (!m478a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m476a(String str) {
        String str2;
        try {
            try {
                str2 = (String) at.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str2 = null;
            }
            return str2;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m477a() {
        if (f800a != null) {
            return;
        }
        f800a = new HashMap();
        f800a.put("CN", o.China);
        f800a.put("FI", o.Europe);
        f800a.put("SE", o.Europe);
        f800a.put("NO", o.Europe);
        f800a.put("FO", o.Europe);
        f800a.put("EE", o.Europe);
        f800a.put("LV", o.Europe);
        f800a.put("LT", o.Europe);
        f800a.put("BY", o.Europe);
        f800a.put("MD", o.Europe);
        f800a.put("UA", o.Europe);
        f800a.put("PL", o.Europe);
        f800a.put("CZ", o.Europe);
        f800a.put("SK", o.Europe);
        f800a.put("HU", o.Europe);
        f800a.put("DE", o.Europe);
        f800a.put("AT", o.Europe);
        f800a.put("CH", o.Europe);
        f800a.put("LI", o.Europe);
        f800a.put("GB", o.Europe);
        f800a.put("IE", o.Europe);
        f800a.put("NL", o.Europe);
        f800a.put("BE", o.Europe);
        f800a.put("LU", o.Europe);
        f800a.put("FR", o.Europe);
        f800a.put("RO", o.Europe);
        f800a.put("BG", o.Europe);
        f800a.put("RS", o.Europe);
        f800a.put("MK", o.Europe);
        f800a.put("AL", o.Europe);
        f800a.put("GR", o.Europe);
        f800a.put("SI", o.Europe);
        f800a.put("HR", o.Europe);
        f800a.put("IT", o.Europe);
        f800a.put("SM", o.Europe);
        f800a.put("MT", o.Europe);
        f800a.put("ES", o.Europe);
        f800a.put("PT", o.Europe);
        f800a.put("AD", o.Europe);
        f800a.put("CY", o.Europe);
        f800a.put("DK", o.Europe);
        f800a.put("RU", o.Russia);
        f800a.put("IN", o.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m478a() {
        boolean z;
        synchronized (l.class) {
            z = a() == 1;
        }
        return z;
    }

    private static o b(String str) {
        m477a();
        return f800a.get(str.toUpperCase());
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
            com.xiaomi.channel.commonutils.logger.b.m42a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m42a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static synchronized boolean m479b() {
        boolean z;
        synchronized (l.class) {
            z = a() == 2;
        }
        return z;
    }

    public static boolean c() {
        if (b < 0) {
            Object a2 = at.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                b = 1;
            }
        }
        return b > 0;
    }

    public static boolean d() {
        return !o.China.name().equalsIgnoreCase(a(b()).name());
    }
}
