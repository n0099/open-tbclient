package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39013a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39014b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39015c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39016d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39017e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39018f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39019g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39018f.invoke(f39013a, Boolean.TRUE);
            } else {
                f39018f.invoke(f39013a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39013a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39014b = cls;
            f39015c = cls.getMethod("reportQQ", Context.class, String.class);
            f39016d = f39014b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39017e = f39014b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39018f = f39013a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39013a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39013a, Boolean.FALSE);
            f39013a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39013a, Boolean.TRUE);
            f39013a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39013a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39013a.getMethod("setStatSendStrategy", cls2).invoke(f39013a, cls2.getField("PERIOD").get(null));
            f39014b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39014b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39019g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39019g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39015c.invoke(f39014b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39019g) {
            b(context, qQToken);
            try {
                f39016d.invoke(f39014b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
