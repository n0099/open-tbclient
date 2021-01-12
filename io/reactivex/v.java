package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public abstract class v {
    static final long qdj = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c eHS();

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public io.reactivex.disposables.b E(Runnable runnable) {
        return b(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        c eHS = eHS();
        a aVar = new a(io.reactivex.d.a.H(runnable), eHS);
        eHS.c(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c eHS = eHS();
        b bVar = new b(io.reactivex.d.a.H(runnable), eHS);
        io.reactivex.disposables.b b2 = eHS.b(bVar, j, j2, timeUnit);
        return b2 == EmptyDisposable.INSTANCE ? b2 : bVar;
    }

    /* loaded from: classes5.dex */
    public static abstract class c implements io.reactivex.disposables.b {
        public abstract io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b F(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable H = io.reactivex.d.a.H(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b c = c(new a(a2 + timeUnit.toNanos(j), H, a2, sequentialDisposable2, nanos), j, timeUnit);
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
            final Runnable qdk;
            final long qdn;
            long qdo;
            long qdp;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.qdk = runnable;
                this.sd = sequentialDisposable;
                this.qdn = j3;
                this.qdo = j2;
                this.qdp = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.qdk.run();
                if (!this.sd.isDisposed()) {
                    long a2 = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.qdj + a2 < this.qdo || a2 >= this.qdo + this.qdn + v.qdj) {
                        j = this.qdn + a2;
                        long j2 = this.qdn;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.qdp = j - (j2 * j3);
                    } else {
                        long j4 = this.qdp;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.qdn);
                    }
                    this.qdo = a2;
                    this.sd.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable qdm;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.qdm = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.qdm.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.O(th);
                    this.worker.dispose();
                    throw ExceptionHelper.Q(th);
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
        final Runnable qdk;
        final c qdl;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.qdk = runnable;
            this.qdl = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.qdk.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.qdl instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.qdl).shutdown();
            } else {
                this.qdl.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qdl.isDisposed();
        }
    }
}
