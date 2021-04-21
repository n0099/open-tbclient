package f.b;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class p {

    /* renamed from: e  reason: collision with root package name */
    public static final long f68613e = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* loaded from: classes7.dex */
    public static final class a implements f.b.t.b, Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f68614e;

        /* renamed from: f  reason: collision with root package name */
        public final c f68615f;

        /* renamed from: g  reason: collision with root package name */
        public Thread f68616g;

        public a(Runnable runnable, c cVar) {
            this.f68614e = runnable;
            this.f68615f = cVar;
        }

        @Override // f.b.t.b
        public void dispose() {
            if (this.f68616g == Thread.currentThread()) {
                c cVar = this.f68615f;
                if (cVar instanceof f.b.x.g.a) {
                    ((f.b.x.g.a) cVar).f();
                    return;
                }
            }
            this.f68615f.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.f68615f.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f68616g = Thread.currentThread();
            try {
                this.f68614e.run();
            } finally {
                dispose();
                this.f68616g = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements f.b.t.b, Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f68617e;

        /* renamed from: f  reason: collision with root package name */
        public final c f68618f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68619g;

        public b(Runnable runnable, c cVar) {
            this.f68617e = runnable;
            this.f68618f = cVar;
        }

        @Override // f.b.t.b
        public void dispose() {
            this.f68619g = true;
            this.f68618f.dispose();
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return this.f68619g;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f68619g) {
                return;
            }
            try {
                this.f68617e.run();
            } catch (Throwable th) {
                f.b.u.a.a(th);
                this.f68618f.dispose();
                throw ExceptionHelper.c(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements f.b.t.b {

        /* loaded from: classes7.dex */
        public final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final Runnable f68620e;

            /* renamed from: f  reason: collision with root package name */
            public final SequentialDisposable f68621f;

            /* renamed from: g  reason: collision with root package name */
            public final long f68622g;

            /* renamed from: h  reason: collision with root package name */
            public long f68623h;
            public long i;
            public long j;

            public a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f68620e = runnable;
                this.f68621f = sequentialDisposable;
                this.f68622g = j3;
                this.i = j2;
                this.j = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f68620e.run();
                if (this.f68621f.isDisposed()) {
                    return;
                }
                long a2 = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = p.f68613e;
                long j3 = this.i;
                if (a2 + j2 >= j3) {
                    long j4 = this.f68622g;
                    if (a2 < j3 + j4 + j2) {
                        long j5 = this.j;
                        long j6 = this.f68623h + 1;
                        this.f68623h = j6;
                        j = j5 + (j6 * j4);
                        this.i = a2;
                        this.f68621f.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                    }
                }
                long j7 = this.f68622g;
                long j8 = a2 + j7;
                long j9 = this.f68623h + 1;
                this.f68623h = j9;
                this.j = j8 - (j7 * j9);
                j = j8;
                this.i = a2;
                this.f68621f.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public abstract f.b.t.b b(Runnable runnable);

        public abstract f.b.t.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public f.b.t.b d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable g2 = f.b.a0.a.g(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            f.b.t.b c2 = c(new a(a2 + timeUnit.toNanos(j), g2, a2, sequentialDisposable2, nanos), j, timeUnit);
            if (c2 == EmptyDisposable.INSTANCE) {
                return c2;
            }
            sequentialDisposable.replace(c2);
            return sequentialDisposable2;
        }
    }

    public abstract c a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public f.b.t.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public f.b.t.b d(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(f.b.a0.a.g(runnable), a2);
        a2.c(aVar, j, timeUnit);
        return aVar;
    }

    public f.b.t.b e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(f.b.a0.a.g(runnable), a2);
        f.b.t.b d2 = a2.d(bVar, j, j2, timeUnit);
        return d2 == EmptyDisposable.INSTANCE ? d2 : bVar;
    }
}
