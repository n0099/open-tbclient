package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class v {
    static final long nRT = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c dSR();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b I(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c dSR = dSR();
        a aVar = new a(io.reactivex.e.a.L(runnable), dSR);
        dSR.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c dSR = dSR();
        b bVar = new b(io.reactivex.e.a.L(runnable), dSR);
        io.reactivex.disposables.b b2 = dSR.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b J(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable L = io.reactivex.e.a.L(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), L, a2, sequentialDisposable2, nanos), j, timeUnit);
            if (c == EmptyDisposable.INSTANCE) {
                return c;
            }
            sequentialDisposable.replace(c);
            return sequentialDisposable2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public final class a implements Runnable {
            long count;
            final Runnable decoratedRun;
            final long nRV;
            long nRW;
            long nRX;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.nRV = j3;
                this.nRW = j2;
                this.nRX = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long a = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.nRT + a < this.nRW || a >= this.nRW + this.nRV + v.nRT) {
                        j = this.nRV + a;
                        long j2 = this.nRV;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.nRX = j - (j2 * j3);
                    } else {
                        long j4 = this.nRX;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.nRV);
                    }
                    this.nRW = a;
                    this.sd.replace(c.this.c(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable nRU;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.nRU = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.nRU.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.K(th);
                    this.worker.dispose();
                    throw ExceptionHelper.M(th);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable decoratedRun;
        Thread runner;
        final c w;

        a(Runnable runnable, c cVar) {
            this.decoratedRun = runnable;
            this.w = cVar;
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
            if (this.runner == Thread.currentThread() && (this.w instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.w).shutdown();
            } else {
                this.w.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.w.isDisposed();
        }
    }
}
