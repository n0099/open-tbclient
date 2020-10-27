package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes15.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4701a = z.b("ro.vivo.product.overseas", "no").equals("yes");
    public static final String b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;
    public static final boolean h;
    private static Method i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;

    public static synchronized String a() {
        String a2;
        synchronized (k.class) {
            if (j == null && k == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    i = declaredMethod;
                    declaredMethod.setAccessible(true);
                    j = (String) i.invoke(null, "ro.vivo.rom", "@><@");
                    k = (String) i.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception e2) {
                    p.b("Device", "getRomCode error");
                }
            }
            p.d("Device", "sRomProperty1 : " + j + " ; sRomProperty2 : " + k);
            a2 = a(j);
            if (TextUtils.isEmpty(a2)) {
                a2 = a(k);
                if (TextUtils.isEmpty(a2)) {
                    a2 = null;
                }
            }
        }
        return a2;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1) + (TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        }
        return null;
    }

    private static boolean b(String str) {
        String b2 = z.b("ro.vivo.rom", "");
        String b3 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        return (b2 != null && b2.contains(str)) || (b3 != null && b3.contains(str));
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_VIVO);
    }

    static {
        String b2;
        if (Build.VERSION.SDK_INT >= 26) {
            b2 = z.b("ro.product.country.region", "N");
        } else {
            b2 = z.b("ro.product.customize.bbk", "N");
        }
        b = b2;
        c = "RU".equals(b);
        d = "IN".equals(b);
        e = b("rom_1.0");
        f = b("rom_2.0");
        g = b("rom_2.5");
        h = b("rom_3.0");
        j = null;
        k = null;
        l = "";
        m = "";
    }
}
