package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39844a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39845b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39846c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39847d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39848e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39849f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39850g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39849f.invoke(f39844a, Boolean.TRUE);
            } else {
                f39849f.invoke(f39844a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39844a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39845b = cls;
            f39846c = cls.getMethod("reportQQ", Context.class, String.class);
            f39847d = f39845b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39848e = f39845b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39849f = f39844a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39844a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39844a, Boolean.FALSE);
            f39844a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39844a, Boolean.TRUE);
            f39844a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39844a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39844a.getMethod("setStatSendStrategy", cls2).invoke(f39844a, cls2.getField("PERIOD").get(null));
            f39845b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39845b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39850g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39850g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39846c.invoke(f39845b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39850g) {
            b(context, qQToken);
            try {
                f39847d.invoke(f39845b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
