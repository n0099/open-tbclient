package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36826a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f36827b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f36828c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f36827b = handlerThread;
        handlerThread.start();
        f36828c = new x(f36827b.getLooper());
    }

    public static void a(v vVar) {
        if (vVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = vVar.a();
        Message message = new Message();
        message.what = a2;
        message.obj = vVar;
        f36828c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f36826a.post(runnable);
    }

    public static void a(Runnable runnable) {
        f36828c.removeCallbacks(runnable);
        f36828c.postDelayed(runnable, 15000L);
    }
}
