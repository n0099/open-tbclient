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
    public final Handler f67692a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f67693e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f67694f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67695g;

        public a(Handler handler) {
            this.f67693e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67695g) {
                return e.c();
            }
            this.f67694f.c(aVar);
            RunnableC1867b runnableC1867b = new RunnableC1867b(aVar, this.f67693e);
            Message obtain = Message.obtain(this.f67693e, runnableC1867b);
            obtain.obj = this;
            this.f67693e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f67695g) {
                this.f67693e.removeCallbacks(runnableC1867b);
                return e.c();
            }
            return runnableC1867b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67695g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67695g = true;
            this.f67693e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1867b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f67696e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f67697f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67698g;

        public RunnableC1867b(h.n.a aVar, Handler handler) {
            this.f67696e = aVar;
            this.f67697f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67698g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f67696e.call();
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
            this.f67698g = true;
            this.f67697f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f67692a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67692a);
    }
}
