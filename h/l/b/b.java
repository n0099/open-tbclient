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
    public final Handler f68436a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f68437e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f68438f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68439g;

        public a(Handler handler) {
            this.f68437e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68439g) {
                return e.c();
            }
            this.f68438f.c(aVar);
            RunnableC1921b runnableC1921b = new RunnableC1921b(aVar, this.f68437e);
            Message obtain = Message.obtain(this.f68437e, runnableC1921b);
            obtain.obj = this;
            this.f68437e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f68439g) {
                this.f68437e.removeCallbacks(runnableC1921b);
                return e.c();
            }
            return runnableC1921b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68439g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68439g = true;
            this.f68437e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1921b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68440e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f68441f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68442g;

        public RunnableC1921b(h.n.a aVar, Handler handler) {
            this.f68440e = aVar;
            this.f68441f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68442g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f68440e.call();
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
            this.f68442g = true;
            this.f68441f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f68436a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68436a);
    }
}
