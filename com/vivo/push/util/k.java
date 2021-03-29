package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39548a = z.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b  reason: collision with root package name */
    public static final String f39549b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f39550c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f39551d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f39552e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f39553f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f39554g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f39555h;
    public static Method i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;

    static {
        String b2;
        if (Build.VERSION.SDK_INT >= 26) {
            b2 = z.b("ro.product.country.region", "N");
        } else {
            b2 = z.b("ro.product.customize.bbk", "N");
        }
        f39549b = b2;
        f39550c = "RU".equals(b2);
        f39551d = "IN".equals(f39549b);
        f39552e = b("rom_1.0");
        f39553f = b("rom_2.0");
        f39554g = b("rom_2.5");
        f39555h = b("rom_3.0");
        j = null;
        k = null;
        l = "";
        m = "";
    }

    public static synchronized String a() {
        synchronized (k.class) {
            if (j == null && k == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    i = declaredMethod;
                    declaredMethod.setAccessible(true);
                    j = (String) i.invoke(null, "ro.vivo.rom", "@><@");
                    k = (String) i.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    p.b("Device", "getRomCode error");
                }
            }
            p.d("Device", "sRomProperty1 : " + j + " ; sRomProperty2 : " + k);
            String a2 = a(j);
            if (TextUtils.isEmpty(a2)) {
                String a3 = a(k);
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
    }

    public static boolean b(String str) {
        String b2 = z.b("ro.vivo.rom", "");
        String b3 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_VIVO);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append(matcher.group(1));
            sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
            return sb.toString();
        }
        return null;
    }
}
