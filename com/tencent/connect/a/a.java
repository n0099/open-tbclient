package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39947a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39948b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39949c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39950d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39951e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39952f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39953g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39952f.invoke(f39947a, Boolean.TRUE);
            } else {
                f39952f.invoke(f39947a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39947a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39948b = cls;
            f39949c = cls.getMethod("reportQQ", Context.class, String.class);
            f39950d = f39948b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39951e = f39948b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39952f = f39947a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39947a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39947a, Boolean.FALSE);
            f39947a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39947a, Boolean.TRUE);
            f39947a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39947a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39947a.getMethod("setStatSendStrategy", cls2).invoke(f39947a, cls2.getField("PERIOD").get(null));
            f39948b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39948b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39953g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39953g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39949c.invoke(f39948b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39953g) {
            b(context, qQToken);
            try {
                f39950d.invoke(f39948b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
