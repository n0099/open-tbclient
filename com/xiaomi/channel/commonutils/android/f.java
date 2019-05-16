package com.xiaomi.channel.commonutils.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {
    private static int a = 0;
    private static int b = -1;
    private static int c = -1;
    private static Map<String, i> d = null;

    public static String a(String str) {
        String str2;
        try {
            try {
                str2 = (String) com.xiaomi.channel.commonutils.reflect.a.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str2 = null;
            }
            return str2;
        } catch (Throwable th) {
            return null;
        }
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (f.class) {
            z = c() == 1;
        }
        return z;
    }

    public static i b(String str) {
        i c2 = c(str);
        return c2 == null ? i.Global : c2;
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (f.class) {
            z = c() == 2;
        }
        return z;
    }

    public static synchronized int c() {
        int i;
        boolean z = false;
        synchronized (f.class) {
            if (a == 0) {
                if (!TextUtils.isEmpty(a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
                    z = true;
                }
                a = z ? 1 : 2;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            i = a;
        }
        return i;
    }

    private static i c(String str) {
        h();
        return d.get(str.toUpperCase());
    }

    public static synchronized String d() {
        String str;
        synchronized (f.class) {
            int b2 = n.b();
            str = (!a() || b2 <= 0) ? "" : b2 < 2 ? "alpha" : b2 < 3 ? "development" : "stable";
        }
        return str;
    }

    public static boolean e() {
        if (b < 0) {
            Object a2 = com.xiaomi.channel.commonutils.reflect.a.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                b = 1;
            }
        }
        return b > 0;
    }

    public static String f() {
        String a2 = m.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = m.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m.a("persist.sys.country", "");
        }
        return TextUtils.isEmpty(a2) ? Locale.getDefault().getCountry() : a2;
    }

    public static boolean g() {
        if (c < 0) {
            if (i.Europe.name().equalsIgnoreCase(b(f()).name()) && a()) {
                c = 1;
            } else {
                c = 0;
            }
        }
        return c > 0;
    }

    private static void h() {
        if (d != null) {
            return;
        }
        d = new HashMap();
        d.put("CN", i.China);
        d.put("FI", i.Europe);
        d.put("SE", i.Europe);
        d.put("NO", i.Europe);
        d.put("FO", i.Europe);
        d.put("EE", i.Europe);
        d.put("LV", i.Europe);
        d.put("LT", i.Europe);
        d.put("BY", i.Europe);
        d.put("MD", i.Europe);
        d.put("UA", i.Europe);
        d.put("PL", i.Europe);
        d.put("CZ", i.Europe);
        d.put("SK", i.Europe);
        d.put("HU", i.Europe);
        d.put("DE", i.Europe);
        d.put("AT", i.Europe);
        d.put("CH", i.Europe);
        d.put("LI", i.Europe);
        d.put("GB", i.Europe);
        d.put("IE", i.Europe);
        d.put("NL", i.Europe);
        d.put("BE", i.Europe);
        d.put("LU", i.Europe);
        d.put("FR", i.Europe);
        d.put("RO", i.Europe);
        d.put("BG", i.Europe);
        d.put("RS", i.Europe);
        d.put("MK", i.Europe);
        d.put("AL", i.Europe);
        d.put("GR", i.Europe);
        d.put("SI", i.Europe);
        d.put("HR", i.Europe);
        d.put("IT", i.Europe);
        d.put("SM", i.Europe);
        d.put("MT", i.Europe);
        d.put("ES", i.Europe);
        d.put("PT", i.Europe);
        d.put("AD", i.Europe);
        d.put("CY", i.Europe);
        d.put("DK", i.Europe);
        d.put("RU", i.Russia);
    }
}
