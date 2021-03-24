package f.a;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class p {

    /* renamed from: e  reason: collision with root package name */
    public static final long f67455e = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* loaded from: classes7.dex */
    public static final class a implements f.a.t.b, Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f67456e;

        /* renamed from: f  reason: collision with root package name */
        public final c f67457f;

        /* renamed from: g  reason: collision with root package name */
        public Thread f67458g;

        public a(Runnable runnable, c cVar) {
            this.f67456e = runnable;
            this.f67457f = cVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            if (this.f67458g == Thread.currentThread()) {
                c cVar = this.f67457f;
                if (cVar instanceof f.a.x.g.a) {
                    ((f.a.x.g.a) cVar).f();
                    return;
                }
            }
            this.f67457f.dispose();
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return this.f67457f.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67458g = Thread.currentThread();
            try {
                this.f67456e.run();
            } finally {
                dispose();
                this.f67458g = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements f.a.t.b, Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f67459e;

        /* renamed from: f  reason: collision with root package name */
        public final c f67460f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f67461g;

        public b(Runnable runnable, c cVar) {
            this.f67459e = runnable;
            this.f67460f = cVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            this.f67461g = true;
            this.f67460f.dispose();
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return this.f67461g;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f67461g) {
                return;
            }
            try {
                this.f67459e.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                this.f67460f.dispose();
                throw ExceptionHelper.c(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements f.a.t.b {

        /* loaded from: classes7.dex */
        public final class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final Runnable f67462e;

            /* renamed from: f  reason: collision with root package name */
            public final SequentialDisposable f67463f;

            /* renamed from: g  reason: collision with root package name */
            public final long f67464g;

            /* renamed from: h  reason: collision with root package name */
            public long f67465h;
            public long i;
            public long j;

            public a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f67462e = runnable;
                this.f67463f = sequentialDisposable;
                this.f67464g = j3;
                this.i = j2;
                this.j = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f67462e.run();
                if (this.f67463f.isDisposed()) {
                    return;
                }
                long a2 = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = p.f67455e;
                long j3 = this.i;
                if (a2 + j2 >= j3) {
                    long j4 = this.f67464g;
                    if (a2 < j3 + j4 + j2) {
                        long j5 = this.j;
                        long j6 = this.f67465h + 1;
                        this.f67465h = j6;
                        j = j5 + (j6 * j4);
                        this.i = a2;
                        this.f67463f.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
                    }
                }
                long j7 = this.f67464g;
                long j8 = a2 + j7;
                long j9 = this.f67465h + 1;
                this.f67465h = j9;
                this.j = j8 - (j7 * j9);
                j = j8;
                this.i = a2;
                this.f67463f.replace(c.this.c(this, j - a2, TimeUnit.NANOSECONDS));
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public abstract f.a.t.b b(Runnable runnable);

        public abstract f.a.t.b c(Runnable runnable, long j, TimeUnit timeUnit);

        public f.a.t.b d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable g2 = f.a.a0.a.g(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            f.a.t.b c2 = c(new a(a2 + timeUnit.toNanos(j), g2, a2, sequentialDisposable2, nanos), j, timeUnit);
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

    public f.a.t.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public f.a.t.b d(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(f.a.a0.a.g(runnable), a2);
        a2.c(aVar, j, timeUnit);
        return aVar;
    }

    public f.a.t.b e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(f.a.a0.a.g(runnable), a2);
        f.a.t.b d2 = a2.d(bVar, j, j2, timeUnit);
        return d2 == EmptyDisposable.INSTANCE ? d2 : bVar;
    }
}
