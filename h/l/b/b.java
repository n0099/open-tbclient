package h.l.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import h.g;
import h.k;
import h.r.f;
import h.u.e;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f67713a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f67714e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f67715f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67716g;

        public a(Handler handler) {
            this.f67714e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67716g) {
                return e.c();
            }
            this.f67715f.c(aVar);
            RunnableC1854b runnableC1854b = new RunnableC1854b(aVar, this.f67714e);
            Message obtain = Message.obtain(this.f67714e, runnableC1854b);
            obtain.obj = this;
            this.f67714e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f67716g) {
                this.f67714e.removeCallbacks(runnableC1854b);
                return e.c();
            }
            return runnableC1854b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67716g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67716g = true;
            this.f67714e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1854b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f67717e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f67718f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67719g;

        public RunnableC1854b(h.n.a aVar, Handler handler) {
            this.f67717e = aVar;
            this.f67718f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67719g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f67717e.call();
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                f.c().b().a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67719g = true;
            this.f67718f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f67713a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67713a);
    }
}
