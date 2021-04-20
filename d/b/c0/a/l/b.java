package d.b.c0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0583b f43060f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f43061e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f43062a;

        /* renamed from: b  reason: collision with root package name */
        public final T f43063b;

        public a(b bVar, T t) {
            this.f43062a = bVar;
            this.f43063b = t;
        }
    }

    /* renamed from: d.b.c0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0583b extends Handler {
        public HandlerC0583b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f43062a.g(aVar.f43063b);
            } else if (i == 2) {
                aVar.f43062a.f((Throwable) aVar.f43063b);
            } else if (i != 3) {
            } else {
                aVar.f43062a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0583b handlerC0583b;
        synchronized (b.class) {
            if (f43060f == null) {
                f43060f = new HandlerC0583b(Looper.getMainLooper());
            }
            handlerC0583b = f43060f;
        }
        return handlerC0583b;
    }

    public void a(boolean z) {
        Future<T> future = this.f43061e;
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
        this.f43061e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
