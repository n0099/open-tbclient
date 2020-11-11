package io.reactivex.a.b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.c;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b extends v {
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.handler = handler;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC1067b runnableC1067b = new RunnableC1067b(this.handler, io.reactivex.e.a.K(runnable));
        this.handler.postDelayed(runnableC1067b, timeUnit.toMillis(j));
        return runnableC1067b;
    }

    @Override // io.reactivex.v
    public v.c eAA() {
        return new a(this.handler);
    }

    /* loaded from: classes8.dex */
    private static final class a extends v.c {
        private volatile boolean disposed;
        private final Handler handler;

        a(Handler handler) {
            this.handler = handler;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.disposed) {
                return c.eAD();
            }
            RunnableC1067b runnableC1067b = new RunnableC1067b(this.handler, io.reactivex.e.a.K(runnable));
            Message obtain = Message.obtain(this.handler, runnableC1067b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.disposed) {
                this.handler.removeCallbacks(runnableC1067b);
                return c.eAD();
            }
            return runnableC1067b;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* renamed from: io.reactivex.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static final class RunnableC1067b implements io.reactivex.disposables.b, Runnable {
        private volatile boolean disposed;
        private final Handler handler;
        private final Runnable pMj;

        RunnableC1067b(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.pMj = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.pMj.run();
            } catch (Throwable th) {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacks(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
