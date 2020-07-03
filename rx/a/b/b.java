package rx.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.c.f;
import rx.exceptions.OnErrorNotImplementedException;
import rx.g;
import rx.k;
import rx.subscriptions.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends g {
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Looper looper) {
        this.handler = new Handler(looper);
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.handler);
    }

    /* loaded from: classes6.dex */
    static class a extends g.a {
        private final Handler handler;
        private final rx.a.a.b obc = rx.a.a.a.dUk().dUl();
        private volatile boolean obd;

        a(Handler handler) {
            this.handler = handler;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.obd = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.obd;
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.obd) {
                return e.dVO();
            }
            RunnableC0912b runnableC0912b = new RunnableC0912b(this.obc.d(aVar), this.handler);
            Message obtain = Message.obtain(this.handler, runnableC0912b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.obd) {
                this.handler.removeCallbacks(runnableC0912b);
                return e.dVO();
            }
            return runnableC0912b;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class RunnableC0912b implements Runnable, k {
        private final rx.functions.a action;
        private final Handler handler;
        private volatile boolean obd;

        RunnableC0912b(rx.functions.a aVar, Handler handler) {
            this.action = aVar;
            this.handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.action.call();
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                f.dVk().dVl().H(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            this.obd = true;
            this.handler.removeCallbacks(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.obd;
        }
    }
}
