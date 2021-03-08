package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public abstract class v {
    static final long qoq = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c eJY();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b B(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c eJY = eJY();
        a aVar = new a(io.reactivex.d.a.E(runnable), eJY);
        eJY.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c eJY = eJY();
        b bVar = new b(io.reactivex.d.a.E(runnable), eJY);
        io.reactivex.disposables.b b2 = eJY.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes6.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b C(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable E = io.reactivex.d.a.E(runnable);
            long nanos = timeUnit.toNanos(j2);
            long b = b(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(b + timeUnit.toNanos(j), E, b, sequentialDisposable2, nanos), j, timeUnit);
            if (c == EmptyDisposable.INSTANCE) {
                return c;
            }
            sequentialDisposable.replace(c);
            return sequentialDisposable2;
        }

        public long b(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public final class a implements Runnable {
            long count;
            final Runnable qor;
            final long qou;
            long qov;
            long qow;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.qor = runnable;
                this.sd = sequentialDisposable;
                this.qou = j3;
                this.qov = j2;
                this.qow = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.qor.run();
                if (!this.sd.isDisposed()) {
                    long b = c.this.b(TimeUnit.NANOSECONDS);
                    if (v.qoq + b < this.qov || b >= this.qov + this.qou + v.qoq) {
                        j = this.qou + b;
                        long j2 = this.qou;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.qow = j - (j2 * j3);
                    } else {
                        long j4 = this.qow;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.qou);
                    }
                    this.qov = b;
                    this.sd.replace(c.this.c(this, j - b, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable qot;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.qot = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.qot.run();
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
    /* loaded from: classes6.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable qor;
        final c qos;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.qor = runnable;
            this.qos = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.qor.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.qos instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.qos).shutdown();
            } else {
                this.qos.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qos.isDisposed();
        }
    }
}
