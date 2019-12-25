package com.xiaomi.push;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes5.dex */
public class l {
    private static int a = 0;
    private static int b = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, o> f802a = null;

    public static synchronized int a() {
        int i;
        boolean z = false;
        synchronized (l.class) {
            if (a == 0) {
                if (!TextUtils.isEmpty(m467a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(m467a("ro.miui.ui.version.name"))) {
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
    public static synchronized String m466a() {
        String str;
        synchronized (l.class) {
            int a2 = t.a();
            str = (!m469a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m467a(String str) {
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
    private static void m468a() {
        if (f802a != null) {
            return;
        }
        f802a = new HashMap();
        f802a.put("CN", o.China);
        f802a.put("FI", o.Europe);
        f802a.put("SE", o.Europe);
        f802a.put("NO", o.Europe);
        f802a.put("FO", o.Europe);
        f802a.put("EE", o.Europe);
        f802a.put("LV", o.Europe);
        f802a.put("LT", o.Europe);
        f802a.put("BY", o.Europe);
        f802a.put("MD", o.Europe);
        f802a.put("UA", o.Europe);
        f802a.put("PL", o.Europe);
        f802a.put("CZ", o.Europe);
        f802a.put("SK", o.Europe);
        f802a.put("HU", o.Europe);
        f802a.put("DE", o.Europe);
        f802a.put("AT", o.Europe);
        f802a.put("CH", o.Europe);
        f802a.put("LI", o.Europe);
        f802a.put("GB", o.Europe);
        f802a.put("IE", o.Europe);
        f802a.put("NL", o.Europe);
        f802a.put("BE", o.Europe);
        f802a.put("LU", o.Europe);
        f802a.put("FR", o.Europe);
        f802a.put("RO", o.Europe);
        f802a.put("BG", o.Europe);
        f802a.put("RS", o.Europe);
        f802a.put("MK", o.Europe);
        f802a.put("AL", o.Europe);
        f802a.put("GR", o.Europe);
        f802a.put("SI", o.Europe);
        f802a.put("HR", o.Europe);
        f802a.put("IT", o.Europe);
        f802a.put("SM", o.Europe);
        f802a.put("MT", o.Europe);
        f802a.put("ES", o.Europe);
        f802a.put("PT", o.Europe);
        f802a.put("AD", o.Europe);
        f802a.put("CY", o.Europe);
        f802a.put("DK", o.Europe);
        f802a.put("RU", o.Russia);
        f802a.put("IN", o.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m469a() {
        boolean z;
        synchronized (l.class) {
            z = a() == 1;
        }
        return z;
    }

    private static o b(String str) {
        m468a();
        return f802a.get(str.toUpperCase());
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
            com.xiaomi.channel.commonutils.logger.b.m33a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m33a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static synchronized boolean m470b() {
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
