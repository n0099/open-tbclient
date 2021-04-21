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
    public final Handler f68850a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f68851e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f68852f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68853g;

        public a(Handler handler) {
            this.f68851e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f68853g) {
                return e.c();
            }
            this.f68852f.c(aVar);
            RunnableC1907b runnableC1907b = new RunnableC1907b(aVar, this.f68851e);
            Message obtain = Message.obtain(this.f68851e, runnableC1907b);
            obtain.obj = this;
            this.f68851e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f68853g) {
                this.f68851e.removeCallbacks(runnableC1907b);
                return e.c();
            }
            return runnableC1907b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68853g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68853g = true;
            this.f68851e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1907b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f68854e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f68855f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68856g;

        public RunnableC1907b(h.n.a aVar, Handler handler) {
            this.f68854e = aVar;
            this.f68855f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68856g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f68854e.call();
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
            this.f68856g = true;
            this.f68855f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f68850a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68850a);
    }
}
