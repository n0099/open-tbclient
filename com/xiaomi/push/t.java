package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static Context f39001a;

    /* renamed from: a  reason: collision with other field name */
    public static String f982a;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m624a() {
        return f39001a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m625a() {
        synchronized (t.class) {
            if (f982a != null) {
                return f982a;
            }
            String str = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b2 = b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = c();
                    if (TextUtils.isEmpty(b2)) {
                        b2 = d();
                        if (TextUtils.isEmpty(b2)) {
                            str = String.valueOf(s.a("ro.product.brand", "Android") + "_" + str);
                        }
                    }
                }
                str = b2;
            }
            f982a = str;
            return str;
        }
    }

    public static String a(Context context) {
        if (l.m526b()) {
            return "";
        }
        String str = (String) bh.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m626a(Context context) {
        f39001a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m627a() {
        return TextUtils.equals((String) bh.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m628a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    public static String b() {
        String a2 = s.a("ro.build.version.emui", "");
        f982a = a2;
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m629b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    public static String c() {
        String a2 = s.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f982a = "ColorOS_" + a2;
        }
        return f982a;
    }

    public static String d() {
        String a2 = s.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f982a = "FuntouchOS_" + a2;
        }
        return f982a;
    }
}
