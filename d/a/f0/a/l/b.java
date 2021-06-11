package d.a.f0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0593b f43536f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f43537e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f43538a;

        /* renamed from: b  reason: collision with root package name */
        public final T f43539b;

        public a(b bVar, T t) {
            this.f43538a = bVar;
            this.f43539b = t;
        }
    }

    /* renamed from: d.a.f0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0593b extends Handler {
        public HandlerC0593b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f43538a.g(aVar.f43539b);
            } else if (i2 == 2) {
                aVar.f43538a.f((Throwable) aVar.f43539b);
            } else if (i2 != 3) {
            } else {
                aVar.f43538a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0593b handlerC0593b;
        synchronized (b.class) {
            if (f43536f == null) {
                f43536f = new HandlerC0593b(Looper.getMainLooper());
            }
            handlerC0593b = f43536f;
        }
        return handlerC0593b;
    }

    public void a(boolean z) {
        Future<T> future = this.f43537e;
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
        this.f43537e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
