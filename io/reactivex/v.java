package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public abstract class v {
    static final long qnO = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c eKq();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b D(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c eKq = eKq();
        a aVar = new a(io.reactivex.d.a.G(runnable), eKq);
        eKq.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c eKq = eKq();
        b bVar = new b(io.reactivex.d.a.G(runnable), eKq);
        io.reactivex.disposables.b b2 = eKq.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes5.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b E(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable G = io.reactivex.d.a.G(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), G, a2, sequentialDisposable2, nanos), j, timeUnit);
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
        /* loaded from: classes5.dex */
        public final class a implements Runnable {
            long count;
            final Runnable qnP;
            final long qnS;
            long qnT;
            long qnU;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.qnP = runnable;
                this.sd = sequentialDisposable;
                this.qnS = j3;
                this.qnT = j2;
                this.qnU = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.qnP.run();
                if (!this.sd.isDisposed()) {
                    long a2 = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.qnO + a2 < this.qnT || a2 >= this.qnT + this.qnS + v.qnO) {
                        j = this.qnS + a2;
                        long j2 = this.qnS;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.qnU = j - (j2 * j3);
                    } else {
                        long j4 = this.qnU;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.qnS);
                    }
                    this.qnT = a2;
                    this.sd.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable qnR;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.qnR = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.qnR.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.N(th);
                    this.worker.dispose();
                    throw ExceptionHelper.P(th);
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
    /* loaded from: classes5.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable qnP;
        final c qnQ;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.qnP = runnable;
            this.qnQ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.qnP.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.qnQ instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.qnQ).shutdown();
            } else {
                this.qnQ.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qnQ.isDisposed();
        }
    }
}
