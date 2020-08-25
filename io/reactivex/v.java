package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class v {
    static final long olQ = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c eeU();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b F(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c eeU = eeU();
        a aVar = new a(io.reactivex.e.a.I(runnable), eeU);
        eeU.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c eeU = eeU();
        b bVar = new b(io.reactivex.e.a.I(runnable), eeU);
        io.reactivex.disposables.b b2 = eeU.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b G(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable I = io.reactivex.e.a.I(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), I, a2, sequentialDisposable2, nanos), j, timeUnit);
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
            final long olS;
            long olT;
            long olU;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.olS = j3;
                this.olT = j2;
                this.olU = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long a = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.olQ + a < this.olT || a >= this.olT + this.olS + v.olQ) {
                        j = this.olS + a;
                        long j2 = this.olS;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.olU = j - (j2 * j3);
                    } else {
                        long j4 = this.olU;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.olS);
                    }
                    this.olT = a;
                    this.sd.replace(c.this.c(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable olR;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.olR = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.olR.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    this.worker.dispose();
                    throw ExceptionHelper.L(th);
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
