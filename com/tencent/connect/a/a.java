package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f13578a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f13579b = null;
    private static Method c = null;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static boolean g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(f13578a, true);
            } else {
                f.invoke(f13578a, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f13578a = Class.forName("com.tencent.stat.StatConfig");
            f13579b = Class.forName("com.tencent.stat.StatService");
            c = f13579b.getMethod("reportQQ", Context.class, String.class);
            d = f13579b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            e = f13579b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f = f13578a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f13578a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f13578a, false);
            f13578a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f13578a, true);
            f13578a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f13578a, 1440);
            Class<?> cls = Class.forName("com.tencent.stat.StatReportStrategy");
            f13578a.getMethod("setStatSendStrategy", cls).invoke(f13578a, cls.getField("PERIOD").get(null));
            f13579b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f13579b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(f13579b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(f13579b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
