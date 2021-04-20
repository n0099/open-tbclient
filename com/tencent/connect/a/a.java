package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39302a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39303b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39304c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39305d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39306e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39307f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39308g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39307f.invoke(f39302a, Boolean.TRUE);
            } else {
                f39307f.invoke(f39302a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39302a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39303b = cls;
            f39304c = cls.getMethod("reportQQ", Context.class, String.class);
            f39305d = f39303b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39306e = f39303b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39307f = f39302a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39302a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39302a, Boolean.FALSE);
            f39302a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39302a, Boolean.TRUE);
            f39302a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39302a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39302a.getMethod("setStatSendStrategy", cls2).invoke(f39302a, cls2.getField("PERIOD").get(null));
            f39303b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39303b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39308g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39308g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39304c.invoke(f39303b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39308g) {
            b(context, qQToken);
            try {
                f39305d.invoke(f39303b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
