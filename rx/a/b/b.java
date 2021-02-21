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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    static class a extends g.a {
        private final Handler handler;
        private final rx.a.a.b qyG = rx.a.a.a.eMP().eMQ();
        private volatile boolean qyH;

        a(Handler handler) {
            this.handler = handler;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qyH = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qyH;
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qyH) {
                return e.eOv();
            }
            RunnableC1314b runnableC1314b = new RunnableC1314b(this.qyG.d(aVar), this.handler);
            Message obtain = Message.obtain(this.handler, runnableC1314b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.qyH) {
                this.handler.removeCallbacks(runnableC1314b);
                return e.eOv();
            }
            return runnableC1314b;
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class RunnableC1314b implements Runnable, k {
        private final rx.functions.a action;
        private final Handler handler;
        private volatile boolean qyH;

        RunnableC1314b(rx.functions.a aVar, Handler handler) {
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
                f.eNR().eNS().D(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qyH = true;
            this.handler.removeCallbacks(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qyH;
        }
    }
}
