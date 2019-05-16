package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes3.dex */
public final class t {
    private static final HandlerThread a;
    private static final Handler b;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        a = handlerThread;
        handlerThread.start();
        b = new u(a.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.m.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = sVar.a();
        if (0 > 0) {
            b.removeMessages(a2);
        }
        Message message = new Message();
        message.what = a2;
        message.obj = sVar;
        b.sendMessageDelayed(message, 0L);
    }

    public static void a(Runnable runnable) {
        if (15000 > 0) {
            b.removeCallbacks(runnable);
        }
        b.postDelayed(runnable, 15000L);
    }
}
