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
    public static Context f30622a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30623b = false;

    /* renamed from: c  reason: collision with root package name */
    public static q f30624c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f30625d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f30626e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f30627f;

    /* renamed from: g  reason: collision with root package name */
    public static String f30628g;

    /* renamed from: h  reason: collision with root package name */
    public static String f30629h;
    public static volatile p i;
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
                f30623b = "1".equals(str);
            }
        } catch (Throwable unused) {
            str = "0";
            f30623b = "1".equals(str);
        }
        f30623b = "1".equals(str);
    }

    public static p a(Context context) {
        if (i == null) {
            synchronized (p.class) {
                f30622a = context.getApplicationContext();
                i = new p();
            }
        }
        if (j == null) {
            synchronized (p.class) {
                f30622a = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                f30626e = handlerThread;
                handlerThread.start();
                f30627f = new o(f30626e.getLooper());
                j = new n(f30622a);
                a();
            }
        }
        return i;
    }

    public void a(int i2, String str) {
        synchronized (f30625d) {
            Message obtainMessage = f30627f.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f30627f.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f30625d.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    f30629h = f30628g;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                        }
                    } else if (f30628g != null) {
                        f30628g = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (f30628g == null) {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
                f30628g = null;
            } else {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            }
        }
    }
}
