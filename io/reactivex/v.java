package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public abstract class v {
    static final long mSU = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c dDP();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b B(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c dDP = dDP();
        a aVar = new a(io.reactivex.d.a.E(runnable), dDP);
        dDP.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c dDP = dDP();
        b bVar = new b(io.reactivex.d.a.E(runnable), dDP);
        io.reactivex.disposables.b b2 = dDP.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes4.dex */
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
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), E, a2, sequentialDisposable2, nanos), j, timeUnit);
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
        /* loaded from: classes4.dex */
        public final class a implements Runnable {
            long count;
            final Runnable mSV;
            final long mSY;
            long mSZ;
            long mTa;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.mSV = runnable;
                this.sd = sequentialDisposable;
                this.mSY = j3;
                this.mSZ = j2;
                this.mTa = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.mSV.run();
                if (!this.sd.isDisposed()) {
                    long a = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.mSU + a < this.mSZ || a >= this.mSZ + this.mSY + v.mSU) {
                        j = this.mSY + a;
                        long j2 = this.mSY;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.mTa = j - (j2 * j3);
                    } else {
                        long j4 = this.mTa;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.mSY);
                    }
                    this.mSZ = a;
                    this.sd.replace(c.this.c(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable mSX;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.mSX = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.mSX.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    this.worker.dispose();
                    throw ExceptionHelper.K(th);
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
    /* loaded from: classes4.dex */
    public static final class a implements io.reactivex.disposables.b, Runnable {
        final Runnable mSV;
        final c mSW;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.mSV = runnable;
            this.mSW = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.mSV.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.mSW instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.mSW).shutdown();
            } else {
                this.mSW.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.mSW.isDisposed();
        }
    }
}
