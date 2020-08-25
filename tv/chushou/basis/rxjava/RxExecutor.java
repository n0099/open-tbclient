package tv.chushou.basis.rxjava;

import io.reactivex.c.g;
import io.reactivex.disposables.b;
import io.reactivex.e.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.schedulers.f;
import io.reactivex.v;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes6.dex */
public class RxExecutor {
    private static final b EMPTY = new b() { // from class: tv.chushou.basis.rxjava.RxExecutor.1
        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return true;
        }
    };
    private static final String TAG = "RxExecutor";

    public static void initRxJavaPlugins() {
        a.d(new g<Throwable>() { // from class: tv.chushou.basis.rxjava.RxExecutor.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            public void accept(Throwable th) throws Exception {
                if ((th instanceof UndeliverableException) || (th instanceof OnErrorNotImplementedException)) {
                    th = th.getCause();
                }
                if (!(th instanceof SocketException) && !(th instanceof SocketTimeoutException) && !(th instanceof IOException) && !(th instanceof InterruptedException)) {
                    if ((th instanceof NullPointerException) || (th instanceof IllegalArgumentException)) {
                        if (tv.chushou.a.a.c.a.elU().elV()) {
                            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                        }
                    } else if (th instanceof IllegalStateException) {
                        if (tv.chushou.a.a.c.a.elU().elV()) {
                            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                        }
                    } else {
                        tv.chushou.a.a.c.a.elU().e("RxJava UnHandled Exceptions", "Default Error Handler:", th);
                    }
                }
            }
        });
    }

    public static b post(io.reactivex.disposables.a aVar, EventThread eventThread, Runnable runnable) {
        if (runnable == null) {
            return EMPTY;
        }
        b scheduleDirect = scheduleDirect(aVar, EventThread.getScheduler(eventThread), runnable);
        if (aVar != null) {
            aVar.a(scheduleDirect);
            return scheduleDirect;
        }
        return scheduleDirect;
    }

    public static b postDelayed(io.reactivex.disposables.a aVar, EventThread eventThread, long j, TimeUnit timeUnit, Runnable runnable) {
        if (runnable == null) {
            return EMPTY;
        }
        b scheduleDirect = scheduleDirect(aVar, EventThread.getScheduler(eventThread), runnable, j, timeUnit);
        if (aVar != null) {
            aVar.a(scheduleDirect);
            return scheduleDirect;
        }
        return scheduleDirect;
    }

    public static b schedulePeriodically(io.reactivex.disposables.a aVar, EventThread eventThread, long j, long j2, TimeUnit timeUnit, Runnable runnable) {
        if (runnable == null) {
            return EMPTY;
        }
        b a = EventThread.getScheduler(eventThread).a(runnable, j, j2, timeUnit);
        if (aVar != null) {
            aVar.a(a);
            return a;
        }
        return a;
    }

    static b scheduleDirect(io.reactivex.disposables.a aVar, v vVar, Runnable runnable) {
        return scheduleDirect(aVar, vVar, runnable, 0L, TimeUnit.NANOSECONDS);
    }

    static b scheduleDirect(io.reactivex.disposables.a aVar, v vVar, Runnable runnable, long j, TimeUnit timeUnit) {
        if (aVar != null && aVar.isDisposed()) {
            return EMPTY;
        }
        v.c eeU = vVar.eeU();
        DisposeTask disposeTask = new DisposeTask(a.I(runnable), eeU, aVar);
        eeU.c(disposeTask, j, timeUnit);
        return disposeTask;
    }

    /* loaded from: classes6.dex */
    public static class DisposeTask implements b, Runnable {
        final io.reactivex.disposables.a c;
        final Runnable decoratedRun;
        Thread runner;
        final v.c w;

        DisposeTask(Runnable runnable, v.c cVar, io.reactivex.disposables.a aVar) {
            this.decoratedRun = runnable;
            this.w = cVar;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.w instanceof f)) {
                ((f) this.w).shutdown();
            } else {
                this.w.dispose();
            }
            if (this.c != null) {
                this.c.c(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.w.isDisposed();
        }
    }
}
