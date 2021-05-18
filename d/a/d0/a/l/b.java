package d.a.d0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0531b f39869f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f39870e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f39871a;

        /* renamed from: b  reason: collision with root package name */
        public final T f39872b;

        public a(b bVar, T t) {
            this.f39871a = bVar;
            this.f39872b = t;
        }
    }

    /* renamed from: d.a.d0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0531b extends Handler {
        public HandlerC0531b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f39871a.g(aVar.f39872b);
            } else if (i2 == 2) {
                aVar.f39871a.f((Throwable) aVar.f39872b);
            } else if (i2 != 3) {
            } else {
                aVar.f39871a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0531b handlerC0531b;
        synchronized (b.class) {
            if (f39869f == null) {
                f39869f = new HandlerC0531b(Looper.getMainLooper());
            }
            handlerC0531b = f39869f;
        }
        return handlerC0531b;
    }

    public void a(boolean z) {
        Future<T> future = this.f39870e;
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
        this.f39870e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
