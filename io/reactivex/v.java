package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public abstract class v {
    static final long pEA = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c eCW();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b G(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c eCW = eCW();
        a aVar = new a(io.reactivex.d.a.J(runnable), eCW);
        eCW.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c eCW = eCW();
        b bVar = new b(io.reactivex.d.a.J(runnable), eCW);
        io.reactivex.disposables.b b2 = eCW.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes9.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b H(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable J = io.reactivex.d.a.J(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), J, a2, sequentialDisposable2, nanos), j, timeUnit);
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
        /* loaded from: classes9.dex */
        public final class a implements Runnable {
            long count;
            final Runnable pEB;
            final long pEE;
            long pEF;
            long pEG;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.pEB = runnable;
                this.sd = sequentialDisposable;
                this.pEE = j3;
                this.pEF = j2;
                this.pEG = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.pEB.run();
                if (!this.sd.isDisposed()) {
                    long a2 = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.pEA + a2 < this.pEF || a2 >= this.pEF + this.pEE + v.pEA) {
                        j = this.pEE + a2;
                        long j2 = this.pEE;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.pEG = j - (j2 * j3);
                    } else {
                        long j4 = this.pEG;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.pEE);
                    }
                    this.pEF = a2;
                    this.sd.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable pED;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.pED = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.pED.run();
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
    /* loaded from: classes9.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable pEB;
        final c pEC;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.pEB = runnable;
            this.pEC = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.pEB.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.pEC instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.pEC).shutdown();
            } else {
                this.pEC.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.pEC.isDisposed();
        }
    }
}
