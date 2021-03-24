package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39012a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39013b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39014c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39015d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39016e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39017f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39018g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39017f.invoke(f39012a, Boolean.TRUE);
            } else {
                f39017f.invoke(f39012a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39012a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39013b = cls;
            f39014c = cls.getMethod("reportQQ", Context.class, String.class);
            f39015d = f39013b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39016e = f39013b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39017f = f39012a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39012a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39012a, Boolean.FALSE);
            f39012a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39012a, Boolean.TRUE);
            f39012a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39012a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39012a.getMethod("setStatSendStrategy", cls2).invoke(f39012a, cls2.getField("PERIOD").get(null));
            f39013b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39013b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39018g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39018g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39014c.invoke(f39013b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39018g) {
            b(context, qQToken);
            try {
                f39015d.invoke(f39013b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
