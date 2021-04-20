package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f39881a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f39882b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f39883c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f39882b = handlerThread;
        handlerThread.start();
        f39883c = new x(f39882b.getLooper());
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
        f39883c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f39881a.post(runnable);
    }

    public static void a(Runnable runnable) {
        f39883c.removeCallbacks(runnable);
        f39883c.postDelayed(runnable, 15000L);
    }
}
