package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f36165a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f36166b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f36167c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f36168d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f36169e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f36170f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f36171g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f36170f.invoke(f36165a, Boolean.TRUE);
            } else {
                f36170f.invoke(f36165a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f36165a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f36166b = cls;
            f36167c = cls.getMethod("reportQQ", Context.class, String.class);
            f36168d = f36166b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f36169e = f36166b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f36170f = f36165a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f36165a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f36165a, Boolean.FALSE);
            f36165a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f36165a, Boolean.TRUE);
            f36165a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f36165a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f36165a.getMethod("setStatSendStrategy", cls2).invoke(f36165a, cls2.getField("PERIOD").get(null));
            f36166b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f36166b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f36171g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f36171g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f36167c.invoke(f36166b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f36171g) {
            b(context, qQToken);
            try {
                f36168d.invoke(f36166b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
