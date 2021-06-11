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
/* loaded from: classes8.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f71692a;

    /* loaded from: classes8.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f71693e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f71694f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71695g;

        public a(Handler handler) {
            this.f71693e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f71695g) {
                return e.c();
            }
            this.f71694f.c(aVar);
            RunnableC1970b runnableC1970b = new RunnableC1970b(aVar, this.f71693e);
            Message obtain = Message.obtain(this.f71693e, runnableC1970b);
            obtain.obj = this;
            this.f71693e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f71695g) {
                this.f71693e.removeCallbacks(runnableC1970b);
                return e.c();
            }
            return runnableC1970b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71695g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71695g = true;
            this.f71693e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC1970b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f71696e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f71697f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71698g;

        public RunnableC1970b(h.n.a aVar, Handler handler) {
            this.f71696e = aVar;
            this.f71697f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71698g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f71696e.call();
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
            this.f71698g = true;
            this.f71697f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f71692a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f71692a);
    }
}
