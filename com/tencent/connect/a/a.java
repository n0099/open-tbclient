package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f39397a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f39398b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f39399c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f39400d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f39401e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Method f39402f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f39403g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return f.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f39402f.invoke(f39397a, Boolean.TRUE);
            } else {
                f39402f.invoke(f39397a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f39397a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f39398b = cls;
            f39399c = cls.getMethod("reportQQ", Context.class, String.class);
            f39400d = f39398b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f39401e = f39398b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f39402f = f39397a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            f39397a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f39397a, Boolean.FALSE);
            f39397a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f39397a, Boolean.TRUE);
            f39397a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f39397a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f39397a.getMethod("setStatSendStrategy", cls2).invoke(f39397a, cls2.getField("PERIOD").get(null));
            f39398b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f39398b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f39403g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f39403g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f39399c.invoke(f39398b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f39403g) {
            b(context, qQToken);
            try {
                f39400d.invoke(f39398b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
