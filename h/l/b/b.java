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
    public final Handler f71796a;

    /* loaded from: classes8.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f71797e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f71798f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71799g;

        public a(Handler handler) {
            this.f71797e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f71799g) {
                return e.c();
            }
            this.f71798f.c(aVar);
            RunnableC1973b runnableC1973b = new RunnableC1973b(aVar, this.f71797e);
            Message obtain = Message.obtain(this.f71797e, runnableC1973b);
            obtain.obj = this;
            this.f71797e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f71799g) {
                this.f71797e.removeCallbacks(runnableC1973b);
                return e.c();
            }
            return runnableC1973b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71799g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71799g = true;
            this.f71797e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC1973b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f71800e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f71801f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71802g;

        public RunnableC1973b(h.n.a aVar, Handler handler) {
            this.f71800e = aVar;
            this.f71801f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71802g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f71800e.call();
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
            this.f71802g = true;
            this.f71801f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f71796a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f71796a);
    }
}
