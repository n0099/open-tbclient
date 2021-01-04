package com.qq.e.comm.plugin.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f12896a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Boolean f12897b = null;
    private static volatile Boolean c = null;
    private static volatile Boolean d = null;
    private static volatile String e = null;
    private static volatile String f = null;
    private static volatile String g = null;
    private static volatile String h = null;
    private static volatile String i = null;
    private static volatile String j = null;
    private static volatile String k = null;
    private static volatile String l = null;

    public static Intent a(String str) {
        if (!TextUtils.isEmpty(str) && a()) {
            String f2 = f();
            String g2 = g();
            ai.b("gdt_tag_appstore", "storePackageName=%s,uri=%s", f2, g2);
            if (!TextUtils.isEmpty(f2) && !TextUtils.isEmpty(g2)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(g2, str)));
                intent.setPackage(f2);
                intent.addFlags(268435456);
                return intent;
            }
        }
        return null;
    }

    private static String a(String str, String str2) {
        String string = GDTADManager.getInstance().getSM().getString(str);
        return !TextUtils.isEmpty(string) ? string : str2;
    }

    public static boolean a() {
        return b() || c() || d() || e();
    }

    public static boolean b() {
        String[] split;
        if (f12896a == null) {
            String a2 = a("m_huawei", "HUAWEI");
            if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                        f12896a = true;
                        return f12896a.booleanValue();
                    }
                }
            }
            f12896a = false;
            return f12896a.booleanValue();
        }
        return f12896a.booleanValue();
    }

    public static boolean c() {
        String[] split;
        if (f12897b == null) {
            String a2 = a("m_oppo", RomUtils.ROM_OPPO);
            if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                        f12897b = true;
                        return f12897b.booleanValue();
                    }
                }
            }
            f12897b = false;
            return f12897b.booleanValue();
        }
        return f12897b.booleanValue();
    }

    public static boolean d() {
        String[] split;
        if (c == null) {
            String a2 = a("m_vivo", RomUtils.MANUFACTURER_VIVO);
            if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                        c = true;
                        return c.booleanValue();
                    }
                }
            }
            c = false;
            return c.booleanValue();
        }
        return c.booleanValue();
    }

    public static boolean e() {
        String[] split;
        if (d == null) {
            String a2 = a("m_xiaomi", "Xiaomi");
            if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                        d = true;
                        return d.booleanValue();
                    }
                }
            }
            d = false;
            return d.booleanValue();
        }
        return d.booleanValue();
    }

    private static String f() {
        if (b()) {
            if (TextUtils.isEmpty(e)) {
                e = a("pkg_huawei", "com.huawei.appmarket");
            }
            return e;
        } else if (c()) {
            if (TextUtils.isEmpty(f)) {
                f = a("pkg_oppo", "com.oppo.market");
            }
            return f;
        } else if (d()) {
            if (TextUtils.isEmpty(g)) {
                g = a("pkg_vivo", "com.bbk.appstore");
            }
            return g;
        } else if (e()) {
            if (TextUtils.isEmpty(h)) {
                h = a("pkg_xiaomi", "com.xiaomi.market");
            }
            return h;
        } else {
            return null;
        }
    }

    private static String g() {
        if (b()) {
            if (TextUtils.isEmpty(i)) {
                i = a("uri_huawei", "market://details?id=%s");
            }
            return i;
        } else if (c()) {
            if (TextUtils.isEmpty(j)) {
                j = a("uri_oppo", "market://details?id=%s");
            }
            return j;
        } else if (d()) {
            if (TextUtils.isEmpty(k)) {
                k = a("uri_vivo", "market://details?id=%s");
            }
            return k;
        } else if (e()) {
            if (TextUtils.isEmpty(l)) {
                l = a("uri_xiaomi", "market://details?id=%s");
            }
            return l;
        } else {
            return null;
        }
    }
}
