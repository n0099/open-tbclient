package d.a.d0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0544b f40624f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f40625e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f40626a;

        /* renamed from: b  reason: collision with root package name */
        public final T f40627b;

        public a(b bVar, T t) {
            this.f40626a = bVar;
            this.f40627b = t;
        }
    }

    /* renamed from: d.a.d0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0544b extends Handler {
        public HandlerC0544b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f40626a.g(aVar.f40627b);
            } else if (i2 == 2) {
                aVar.f40626a.f((Throwable) aVar.f40627b);
            } else if (i2 != 3) {
            } else {
                aVar.f40626a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0544b handlerC0544b;
        synchronized (b.class) {
            if (f40624f == null) {
                f40624f = new HandlerC0544b(Looper.getMainLooper());
            }
            handlerC0544b = f40624f;
        }
        return handlerC0544b;
    }

    public void a(boolean z) {
        Future<T> future = this.f40625e;
        if (future != null) {
            future.cancel(z);
            d().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }

    public abstract T b();

    public b c() {
        try {
            System.currentTimeMillis();
            d().obtainMessage(1, new a(this, b())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public void cancel() {
        a(false);
    }

    public void e() {
    }

    public void f(Throwable th) {
    }

    public void g(T t) {
    }

    public void h(Future future) {
        this.f40625e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
