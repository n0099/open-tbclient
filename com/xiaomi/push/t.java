package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes6.dex */
public class t {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static String f947a = null;

    public static int a() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            if (cls.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return cls.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m556a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m557a() {
        String str;
        synchronized (t.class) {
            if (f947a != null) {
                str = f947a;
            } else {
                String str2 = Build.VERSION.INCREMENTAL;
                if (a() <= 0) {
                    str = b();
                    if (TextUtils.isEmpty(str)) {
                        str = c();
                        if (TextUtils.isEmpty(str)) {
                            str = d();
                            if (TextUtils.isEmpty(str)) {
                                str = String.valueOf(s.a("ro.product.brand", "Android") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2);
                            }
                        }
                    }
                } else {
                    str = str2;
                }
                f947a = str;
            }
        }
        return str;
    }

    public static String a(Context context) {
        if (l.m479b()) {
            return "";
        }
        String str = (String) at.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m558a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m559a() {
        return TextUtils.equals((String) at.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m560a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static String b() {
        f947a = s.a("ro.build.version.emui", "");
        return f947a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m561b() {
        try {
            return Class.forName("miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static String c() {
        String a2 = s.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f947a = "ColorOS_" + a2;
        }
        return f947a;
    }

    private static String d() {
        String a2 = s.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f947a = "FuntouchOS_" + a2;
        }
        return f947a;
    }
}
