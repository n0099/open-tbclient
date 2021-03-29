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
    public final Handler f67697a;

    /* loaded from: classes7.dex */
    public static class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final Handler f67698e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f67699f = h.l.a.a.a().b();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67700g;

        public a(Handler handler) {
            this.f67698e = handler;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            return c(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (this.f67700g) {
                return e.c();
            }
            this.f67699f.c(aVar);
            RunnableC1868b runnableC1868b = new RunnableC1868b(aVar, this.f67698e);
            Message obtain = Message.obtain(this.f67698e, runnableC1868b);
            obtain.obj = this;
            this.f67698e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f67700g) {
                this.f67698e.removeCallbacks(runnableC1868b);
                return e.c();
            }
            return runnableC1868b;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67700g;
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67700g = true;
            this.f67698e.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC1868b implements Runnable, k {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f67701e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f67702f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67703g;

        public RunnableC1868b(h.n.a aVar, Handler handler) {
            this.f67701e = aVar;
            this.f67702f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67703g;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f67701e.call();
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
            this.f67703g = true;
            this.f67702f.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.f67697a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67697a);
    }
}
