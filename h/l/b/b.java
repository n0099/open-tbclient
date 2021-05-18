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
    public final Handler f68393a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f68394e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f68395f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68396g;

        public a(Handler handler) {
            this.f68394e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68396g) {
                return e.c();
            }
            this.f68395f.c(aVar);
            RunnableC1917b runnableC1917b = new RunnableC1917b(aVar, this.f68394e);
            Message obtain = Message.obtain(this.f68394e, runnableC1917b);
            obtain.obj = this;
            this.f68394e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f68396g) {
                this.f68394e.removeCallbacks(runnableC1917b);
                return e.c();
            }
            return runnableC1917b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68396g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68396g = true;
            this.f68394e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1917b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68397e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f68398f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68399g;

        public RunnableC1917b(h.n.a aVar, Handler handler) {
            this.f68397e = aVar;
            this.f68398f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68399g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f68397e.call();
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
            this.f68399g = true;
            this.f68398f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f68393a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68393a);
    }
}
