package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
public final class w {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final HandlerThread b;
    private static final Handler c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        c = new x(b.getLooper());
    }

    public static void a(v vVar) {
        if (vVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = vVar.a();
        if (0 > 0) {
            c.removeMessages(a2);
        }
        Message message = new Message();
        message.what = a2;
        message.obj = vVar;
        c.sendMessageDelayed(message, 0L);
    }

    public static void a(Runnable runnable) {
        if (15000 > 0) {
            c.removeCallbacks(runnable);
        }
        c.postDelayed(runnable, 15000L);
    }

    public static void b(Runnable runnable) {
        a.post(runnable);
    }
}
