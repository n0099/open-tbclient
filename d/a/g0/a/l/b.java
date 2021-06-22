package d.a.g0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0596b f43672f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f43673e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f43674a;

        /* renamed from: b  reason: collision with root package name */
        public final T f43675b;

        public a(b bVar, T t) {
            this.f43674a = bVar;
            this.f43675b = t;
        }
    }

    /* renamed from: d.a.g0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0596b extends Handler {
        public HandlerC0596b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f43674a.g(aVar.f43675b);
            } else if (i2 == 2) {
                aVar.f43674a.f((Throwable) aVar.f43675b);
            } else if (i2 != 3) {
            } else {
                aVar.f43674a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0596b handlerC0596b;
        synchronized (b.class) {
            if (f43672f == null) {
                f43672f = new HandlerC0596b(Looper.getMainLooper());
            }
            handlerC0596b = f43672f;
        }
        return handlerC0596b;
    }

    public void a(boolean z) {
        Future<T> future = this.f43673e;
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
        this.f43673e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
