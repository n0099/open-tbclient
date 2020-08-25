package io.reactivex.a.b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.c;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
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
        RunnableC0960b runnableC0960b = new RunnableC0960b(this.handler, io.reactivex.e.a.I(runnable));
        this.handler.postDelayed(runnableC0960b, timeUnit.toMillis(j));
        return runnableC0960b;
    }

    @Override // io.reactivex.v
    public v.c eeU() {
        return new a(this.handler);
    }

    /* loaded from: classes5.dex */
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
                return c.eeX();
            }
            RunnableC0960b runnableC0960b = new RunnableC0960b(this.handler, io.reactivex.e.a.I(runnable));
            Message obtain = Message.obtain(this.handler, runnableC0960b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.disposed) {
                this.handler.removeCallbacks(runnableC0960b);
                return c.eeX();
            }
            return runnableC0960b;
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
    /* loaded from: classes5.dex */
    private static final class RunnableC0960b implements io.reactivex.disposables.b, Runnable {
        private volatile boolean disposed;
        private final Handler handler;
        private final Runnable oma;

        RunnableC0960b(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.oma = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.oma.run();
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
