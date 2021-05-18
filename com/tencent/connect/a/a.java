package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f36236a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f36237b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f36238c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f36239d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f36240e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f36241f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f36242g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f36241f.invoke(f36236a, Boolean.TRUE);
            } else {
                f36241f.invoke(f36236a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f36236a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f36237b = cls;
            f36238c = cls.getMethod("reportQQ", Context.class, String.class);
            f36239d = f36237b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f36240e = f36237b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f36241f = f36236a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f36236a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f36236a, Boolean.FALSE);
            f36236a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f36236a, Boolean.TRUE);
            f36236a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f36236a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f36236a.getMethod("setStatSendStrategy", cls2).invoke(f36236a, cls2.getField("PERIOD").get(null));
            f36237b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f36237b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f36242g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f36242g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f36238c.invoke(f36237b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f36242g) {
            b(context, qQToken);
            try {
                f36239d.invoke(f36237b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
