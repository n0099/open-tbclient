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
    public static final boolean f36710a = z.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b  reason: collision with root package name */
    public static final String f36711b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f36712c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f36713d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f36714e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f36715f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f36716g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f36717h;

    /* renamed from: i  reason: collision with root package name */
    public static Method f36718i;
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
        f36711b = b2;
        f36712c = "RU".equals(b2);
        f36713d = "IN".equals(f36711b);
        f36714e = b("rom_1.0");
        f36715f = b("rom_2.0");
        f36716g = b("rom_2.5");
        f36717h = b("rom_3.0");
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
                    f36718i = declaredMethod;
                    declaredMethod.setAccessible(true);
                    j = (String) f36718i.invoke(null, "ro.vivo.rom", "@><@");
                    k = (String) f36718i.invoke(null, "ro.vivo.rom.version", "@><@");
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
