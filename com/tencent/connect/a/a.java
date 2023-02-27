package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class a {
    public static Class<?> a;
    public static Class<?> b;
    public static Method c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static boolean g;

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (!g) {
            return;
        }
        b(context, qQToken);
        try {
            d.invoke(b, context, str, strArr);
        } catch (Exception e2) {
            SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
        }
    }

    public static boolean a(Context context, QQToken qQToken) {
        return g.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(a, Boolean.TRUE);
            } else {
                f.invoke(a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            b = cls;
            c = cls.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            e = b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f = a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(a, Boolean.FALSE);
            a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(a, Boolean.TRUE);
            a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(a, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", cls2).invoke(a, cls2.getField("PERIOD").get(null));
            b.getMethod("startStatService", Context.class, String.class, String.class).invoke(b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (!g) {
            return;
        }
        b(context, qQToken);
        if (qQToken.getOpenId() != null) {
            try {
                c.invoke(b, context, qQToken.getOpenId());
            } catch (Exception e2) {
                SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
            }
        }
    }
}
