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
/* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
    static class a extends g.a {
        private final Handler handler;
        private final rx.a.a.b qqW = rx.a.a.a.eND().eNE();
        private volatile boolean qqX;

        a(Handler handler) {
            this.handler = handler;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qqX = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qqX;
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qqX) {
                return e.ePj();
            }
            RunnableC1278b runnableC1278b = new RunnableC1278b(this.qqW.d(aVar), this.handler);
            Message obtain = Message.obtain(this.handler, runnableC1278b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.qqX) {
                this.handler.removeCallbacks(runnableC1278b);
                return e.ePj();
            }
            return runnableC1278b;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class RunnableC1278b implements Runnable, k {
        private final rx.functions.a action;
        private final Handler handler;
        private volatile boolean qqX;

        RunnableC1278b(rx.functions.a aVar, Handler handler) {
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
                f.eOF().eOG().E(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qqX = true;
            this.handler.removeCallbacks(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qqX;
        }
    }
}
