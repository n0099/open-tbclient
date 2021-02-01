package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes15.dex */
public abstract class aa {

    /* renamed from: a  reason: collision with root package name */
    protected Context f13562a;

    /* renamed from: b  reason: collision with root package name */
    protected Handler f13563b;
    private final Object c = new Object();

    public abstract void b(Message message);

    public aa() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f13563b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f13562a = context;
    }

    public final void a(Message message) {
        synchronized (this.c) {
            if (this.f13563b == null) {
                com.vivo.push.util.p.e(getClass().getSimpleName(), ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.f13563b.sendMessage(message);
            }
        }
    }

    /* loaded from: classes15.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            aa.this.b(message);
        }
    }
}
