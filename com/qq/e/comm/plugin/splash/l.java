package com.qq.e.comm.plugin.splash;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.at;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f12821a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile long f12822b = 0;

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public static void a(String str) {
        synchronized (f12821a) {
            at.a("splashPlayround" + str, at.b("splashPlayround" + str, 0) + 1);
        }
    }

    public static boolean a(Context context) {
        return GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() > 0 && ab.a(context);
    }

    public static int b(String str) {
        int b2;
        synchronized (f12821a) {
            b2 = at.b("splashPlayround" + str, 0);
        }
        return b2;
    }

    public static boolean b() {
        if (GDTADManager.getInstance().getSM().getInteger("SplashAvoidMultiClick", 1) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (f12822b != 0 && currentTimeMillis - f12822b < 5000) {
                f12822b = currentTimeMillis;
                return true;
            }
            f12822b = currentTimeMillis;
        }
        return false;
    }

    public static void c() {
        synchronized (l.class) {
            try {
                f12822b = 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
