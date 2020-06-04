package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes8.dex */
public class t {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static String f936a = null;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m580a() {
        return a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e) {
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m581a() {
        String str;
        synchronized (t.class) {
            if (f936a != null) {
                str = f936a;
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
                f936a = str;
            }
        }
        return str;
    }

    public static String a(Context context) {
        if (l.m498b()) {
            return "";
        }
        String str = (String) ba.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m582a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m583a() {
        return TextUtils.equals((String) ba.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m584a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static String b() {
        f936a = s.a("ro.build.version.emui", "");
        return f936a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m585b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
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
            f936a = "ColorOS_" + a2;
        }
        return f936a;
    }

    private static String d() {
        String a2 = s.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f936a = "FuntouchOS_" + a2;
        }
        return f936a;
    }
}
