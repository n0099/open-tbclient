package com.fun.openid.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31556a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31557b = false;

    /* renamed from: c  reason: collision with root package name */
    public static q f31558c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f31559d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f31560e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f31561f;

    /* renamed from: g  reason: collision with root package name */
    public static String f31562g;

    /* renamed from: h  reason: collision with root package name */
    public static String f31563h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile p f31564i;
    public static volatile n j;

    public static void a() {
        String str;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "0";
                f31557b = "1".equals(str);
            }
        } catch (Throwable unused) {
            str = "0";
            f31557b = "1".equals(str);
        }
        f31557b = "1".equals(str);
    }

    public static p a(Context context) {
        if (f31564i == null) {
            synchronized (p.class) {
                f31556a = context.getApplicationContext();
                f31564i = new p();
            }
        }
        if (j == null) {
            synchronized (p.class) {
                f31556a = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                f31560e = handlerThread;
                handlerThread.start();
                f31561f = new o(f31560e.getLooper());
                j = new n(f31556a);
                a();
            }
        }
        return f31564i;
    }

    public void a(int i2, String str) {
        synchronized (f31559d) {
            Message obtainMessage = f31561f.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f31561f.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f31559d.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    f31563h = f31562g;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                        }
                    } else if (f31562g != null) {
                        f31562g = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (f31562g == null) {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
                f31562g = null;
            } else {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            }
        }
    }
}
