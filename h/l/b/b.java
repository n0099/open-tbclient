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
    public final Handler f68703a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f68704e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f68705f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68706g;

        public a(Handler handler) {
            this.f68704e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68706g) {
                return e.c();
            }
            this.f68705f.c(aVar);
            RunnableC1903b runnableC1903b = new RunnableC1903b(aVar, this.f68704e);
            Message obtain = Message.obtain(this.f68704e, runnableC1903b);
            obtain.obj = this;
            this.f68704e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f68706g) {
                this.f68704e.removeCallbacks(runnableC1903b);
                return e.c();
            }
            return runnableC1903b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68706g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68706g = true;
            this.f68704e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1903b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68707e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f68708f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68709g;

        public RunnableC1903b(h.n.a aVar, Handler handler) {
            this.f68707e = aVar;
            this.f68708f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68709g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f68707e.call();
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
            this.f68709g = true;
            this.f68708f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f68703a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68703a);
    }
}
