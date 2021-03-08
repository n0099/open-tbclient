package com.pgl.sys.ces.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static double f7477a = -1.0d;

    public static String a() {
        String str = null;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        String str = "";
        com.pgl.sys.ces.d.a e = com.pgl.sys.ces.b.e();
        if (e != null) {
            try {
                str = e.getDeviceId();
            } catch (Throwable th) {
            }
        }
        return str == null ? "" : str.trim();
    }

    public static String b() {
        String str = "";
        try {
            com.pgl.sys.ces.d.a e = com.pgl.sys.ces.b.e();
            if (e != null) {
                str = e.getHardwareAddress();
            }
        } catch (Throwable th) {
        }
        return "" + str;
    }

    @SuppressLint({"MissingPermission"})
    public static String b(Context context) {
        String str = null;
        com.pgl.sys.ces.d.a e = com.pgl.sys.ces.b.e();
        if (e != null) {
            try {
                str = e.getSubscriberId();
            } catch (Throwable th) {
            }
        }
        return str == null ? "" : str.trim();
    }

    public static String c(Context context) {
        String str = null;
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            str = locale.getLanguage() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + locale.getCountry();
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        String str = null;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String e(Context context) {
        double d;
        if (f7477a >= 0.0d) {
            return Integer.toString((int) f7477a);
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
            declaredMethod.setAccessible(true);
            d = ((Double) declaredMethod.invoke(newInstance, "battery.capacity")).doubleValue();
        } catch (Throwable th) {
            d = 0.0d;
        }
        f7477a = d;
        return Integer.toString((int) d);
    }
}
