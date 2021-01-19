package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public abstract class v {
    static final long qdk = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

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
            final Runnable qdl;
            final long qdo;
            long qdp;
            long qdq;
            final SequentialDisposable sd;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.qdl = runnable;
                this.sd = sequentialDisposable;
                this.qdo = j3;
                this.qdp = j2;
                this.qdq = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.qdl.run();
                if (!this.sd.isDisposed()) {
                    long a2 = c.this.a(TimeUnit.NANOSECONDS);
                    if (v.qdk + a2 < this.qdp || a2 >= this.qdp + this.qdo + v.qdk) {
                        j = this.qdo + a2;
                        long j2 = this.qdo;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.qdq = j - (j2 * j3);
                    } else {
                        long j4 = this.qdq;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.qdo);
                    }
                    this.qdp = a2;
                    this.sd.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static class b implements io.reactivex.disposables.b, Runnable {
        volatile boolean disposed;
        final Runnable qdn;
        final c worker;

        b(Runnable runnable, c cVar) {
            this.qdn = runnable;
            this.worker = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.qdn.run();
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
        final Runnable qdl;
        final c qdm;
        Thread runner;

        a(Runnable runnable, c cVar) {
            this.qdl = runnable;
            this.qdm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.qdl.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.runner == Thread.currentThread() && (this.qdm instanceof io.reactivex.internal.schedulers.f)) {
                ((io.reactivex.internal.schedulers.f) this.qdm).shutdown();
            } else {
                this.qdm.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.qdm.isDisposed();
        }
    }
}
