package com.xiaomi.push;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes12.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f5012a = 0;
    private static int b = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, o> f786a = null;

    public static synchronized int a() {
        int i;
        boolean z = false;
        synchronized (l.class) {
            if (f5012a == 0) {
                if (!TextUtils.isEmpty(m499a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(m499a("ro.miui.ui.version.name"))) {
                    z = true;
                }
                f5012a = z ? 1 : 2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f5012a);
            }
            i = f5012a;
        }
        return i;
    }

    public static o a(String str) {
        o b2 = b(str);
        return b2 == null ? o.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m498a() {
        String str;
        synchronized (l.class) {
            int a2 = t.a();
            str = (!m501a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m499a(String str) {
        String str2;
        try {
            try {
                str2 = (String) ba.a("android.os.SystemProperties", "get", str, "");
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
    private static void m500a() {
        if (f786a != null) {
            return;
        }
        f786a = new HashMap();
        f786a.put("CN", o.China);
        f786a.put("FI", o.Europe);
        f786a.put("SE", o.Europe);
        f786a.put("NO", o.Europe);
        f786a.put("FO", o.Europe);
        f786a.put("EE", o.Europe);
        f786a.put("LV", o.Europe);
        f786a.put("LT", o.Europe);
        f786a.put("BY", o.Europe);
        f786a.put("MD", o.Europe);
        f786a.put("UA", o.Europe);
        f786a.put("PL", o.Europe);
        f786a.put("CZ", o.Europe);
        f786a.put("SK", o.Europe);
        f786a.put("HU", o.Europe);
        f786a.put("DE", o.Europe);
        f786a.put("AT", o.Europe);
        f786a.put("CH", o.Europe);
        f786a.put("LI", o.Europe);
        f786a.put("GB", o.Europe);
        f786a.put("IE", o.Europe);
        f786a.put("NL", o.Europe);
        f786a.put("BE", o.Europe);
        f786a.put("LU", o.Europe);
        f786a.put("FR", o.Europe);
        f786a.put("RO", o.Europe);
        f786a.put("BG", o.Europe);
        f786a.put("RS", o.Europe);
        f786a.put("MK", o.Europe);
        f786a.put("AL", o.Europe);
        f786a.put("GR", o.Europe);
        f786a.put("SI", o.Europe);
        f786a.put("HR", o.Europe);
        f786a.put("IT", o.Europe);
        f786a.put("SM", o.Europe);
        f786a.put("MT", o.Europe);
        f786a.put("ES", o.Europe);
        f786a.put("PT", o.Europe);
        f786a.put("AD", o.Europe);
        f786a.put("CY", o.Europe);
        f786a.put("DK", o.Europe);
        f786a.put("RU", o.Russia);
        f786a.put("IN", o.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m501a() {
        boolean z;
        synchronized (l.class) {
            z = a() == 1;
        }
        return z;
    }

    private static o b(String str) {
        m500a();
        return f786a.get(str.toUpperCase());
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
    public static synchronized boolean m502b() {
        boolean z;
        synchronized (l.class) {
            z = a() == 2;
        }
        return z;
    }

    public static boolean c() {
        if (b < 0) {
            Object a2 = ba.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
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
