package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f40434a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f40435b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f40436c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f40435b = handlerThread;
        handlerThread.start();
        f40436c = new x(f40435b.getLooper());
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
        f40436c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f40434a.post(runnable);
    }

    public static void a(Runnable runnable) {
        f40436c.removeCallbacks(runnable);
        f40436c.postDelayed(runnable, 15000L);
    }
}
