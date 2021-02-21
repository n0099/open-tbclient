package com.xiaomi.push;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f14188a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f14189b = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, o> f864a = null;

    public static synchronized int a() {
        int i;
        boolean z = false;
        synchronized (l.class) {
            if (f14188a == 0) {
                if (!TextUtils.isEmpty(m523a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(m523a("ro.miui.ui.version.name"))) {
                    z = true;
                }
                f14188a = z ? 1 : 2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f14188a);
            }
            i = f14188a;
        }
        return i;
    }

    public static o a(String str) {
        o b2 = b(str);
        return b2 == null ? o.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m522a() {
        String str;
        synchronized (l.class) {
            int a2 = t.a();
            str = (!m525a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m523a(String str) {
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
    private static void m524a() {
        if (f864a != null) {
            return;
        }
        f864a = new HashMap();
        f864a.put("CN", o.China);
        f864a.put("FI", o.Europe);
        f864a.put("SE", o.Europe);
        f864a.put("NO", o.Europe);
        f864a.put("FO", o.Europe);
        f864a.put("EE", o.Europe);
        f864a.put("LV", o.Europe);
        f864a.put("LT", o.Europe);
        f864a.put("BY", o.Europe);
        f864a.put("MD", o.Europe);
        f864a.put("UA", o.Europe);
        f864a.put("PL", o.Europe);
        f864a.put("CZ", o.Europe);
        f864a.put("SK", o.Europe);
        f864a.put("HU", o.Europe);
        f864a.put("DE", o.Europe);
        f864a.put("AT", o.Europe);
        f864a.put("CH", o.Europe);
        f864a.put("LI", o.Europe);
        f864a.put("GB", o.Europe);
        f864a.put("IE", o.Europe);
        f864a.put("NL", o.Europe);
        f864a.put("BE", o.Europe);
        f864a.put("LU", o.Europe);
        f864a.put("FR", o.Europe);
        f864a.put("RO", o.Europe);
        f864a.put("BG", o.Europe);
        f864a.put("RS", o.Europe);
        f864a.put("MK", o.Europe);
        f864a.put("AL", o.Europe);
        f864a.put("GR", o.Europe);
        f864a.put("SI", o.Europe);
        f864a.put("HR", o.Europe);
        f864a.put("IT", o.Europe);
        f864a.put("SM", o.Europe);
        f864a.put("MT", o.Europe);
        f864a.put("ES", o.Europe);
        f864a.put("PT", o.Europe);
        f864a.put("AD", o.Europe);
        f864a.put("CY", o.Europe);
        f864a.put("DK", o.Europe);
        f864a.put("RU", o.Russia);
        f864a.put("IN", o.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m525a() {
        boolean z;
        synchronized (l.class) {
            z = a() == 1;
        }
        return z;
    }

    private static o b(String str) {
        m524a();
        return f864a.get(str.toUpperCase());
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
            com.xiaomi.channel.commonutils.logger.b.m79a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m79a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static synchronized boolean m526b() {
        boolean z;
        synchronized (l.class) {
            z = a() == 2;
        }
        return z;
    }

    public static boolean c() {
        if (f14189b < 0) {
            Object a2 = ba.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            f14189b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                f14189b = 1;
            }
        }
        return f14189b > 0;
    }

    public static boolean d() {
        return !o.China.name().equalsIgnoreCase(a(b()).name());
    }
}
