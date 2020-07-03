package io.reactivex.a.b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.c;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
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
        RunnableC0886b runnableC0886b = new RunnableC0886b(this.handler, io.reactivex.e.a.M(runnable));
        this.handler.postDelayed(runnableC0886b, timeUnit.toMillis(j));
        return runnableC0886b;
    }

    @Override // io.reactivex.v
    public v.c dPr() {
        return new a(this.handler);
    }

    /* loaded from: classes6.dex */
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
                return c.dPu();
            }
            RunnableC0886b runnableC0886b = new RunnableC0886b(this.handler, io.reactivex.e.a.M(runnable));
            Message obtain = Message.obtain(this.handler, runnableC0886b);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.disposed) {
                this.handler.removeCallbacks(runnableC0886b);
                return c.dPu();
            }
            return runnableC0886b;
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
    /* loaded from: classes6.dex */
    private static final class RunnableC0886b implements io.reactivex.disposables.b, Runnable {
        private volatile boolean disposed;
        private final Handler handler;
        private final Runnable nJs;

        RunnableC0886b(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.nJs = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.nJs.run();
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
