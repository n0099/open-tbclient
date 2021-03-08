package com.fun.openid.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static Context f5250a;
    public static boolean b;
    public static Object d = new Object();
    public static HandlerThread e;
    public static Handler f;
    public static String g;
    public static String h;
    public static t pRj;
    public static volatile r pRk;
    public static volatile p pRl;

    public static void a() {
        String str;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "0";
            }
        } catch (Throwable th) {
            str = "0";
        }
        b = "1".equals(str);
    }

    public static r io(Context context) {
        if (pRk == null) {
            synchronized (r.class) {
                f5250a = context.getApplicationContext();
                pRk = new r();
            }
        }
        if (pRl == null) {
            synchronized (r.class) {
                f5250a = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                e = handlerThread;
                handlerThread.start();
                f = new q(e.getLooper());
                pRl = new p(f5250a);
                a();
            }
        }
        return pRk;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r11 != 4) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, String str) {
        synchronized (d) {
            Message obtainMessage = f.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            if (i == 1 || i == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                d.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i == 0) {
                    h = g;
                } else if (i != 1) {
                    if (i == 2) {
                        if (g != null) {
                            g = null;
                        } else {
                            Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                        }
                    }
                } else if (g == null) {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
                g = null;
            } else {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            }
        }
    }
}
