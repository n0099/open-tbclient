package d.b.d0.a.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static HandlerC0605b f43382f;

    /* renamed from: e  reason: collision with root package name */
    public Future<T> f43383e;

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final b f43384a;

        /* renamed from: b  reason: collision with root package name */
        public final T f43385b;

        public a(b bVar, T t) {
            this.f43384a = bVar;
            this.f43385b = t;
        }
    }

    /* renamed from: d.b.d0.a.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0605b extends Handler {
        public HandlerC0605b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f43384a.g(aVar.f43385b);
            } else if (i == 2) {
                aVar.f43384a.f((Throwable) aVar.f43385b);
            } else if (i != 3) {
            } else {
                aVar.f43384a.e();
            }
        }
    }

    public static Handler d() {
        HandlerC0605b handlerC0605b;
        synchronized (b.class) {
            if (f43382f == null) {
                f43382f = new HandlerC0605b(Looper.getMainLooper());
            }
            handlerC0605b = f43382f;
        }
        return handlerC0605b;
    }

    public void a(boolean z) {
        Future<T> future = this.f43383e;
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
        this.f43383e = future;
    }

    public void i(long j) {
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }
}
