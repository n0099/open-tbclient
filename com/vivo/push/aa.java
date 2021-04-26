package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public abstract class aa {

    /* renamed from: a  reason: collision with root package name */
    public Context f37337a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f37338b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f37339c = new Object();

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            aa.this.b(message);
        }
    }

    public aa() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f37338b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f37337a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f37339c) {
            if (this.f37338b == null) {
                String simpleName = getClass().getSimpleName();
                com.vivo.push.util.p.e(simpleName, ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                this.f37338b.sendMessage(message);
            }
        }
    }
}
