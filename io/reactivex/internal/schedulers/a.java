package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b nyo;
    static final RxThreadFactory nyp;
    static final int nyq = ej(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nyr = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aNw;
    final AtomicReference<b> nys;

    static {
        nyr.dispose();
        nyp = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nyo = new b(0, nyp);
        nyo.shutdown();
    }

    static int ej(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int nyx;
        final c[] nyy;

        b(int i, ThreadFactory threadFactory) {
            this.nyx = i;
            this.nyy = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nyy[i2] = new c(threadFactory);
            }
        }

        public c dIq() {
            int i = this.nyx;
            if (i == 0) {
                return a.nyr;
            }
            c[] cVarArr = this.nyy;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nyy) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nyx;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nyr);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0758a(this.nyy[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nyp);
    }

    public a(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        this.nys = new AtomicReference<>(nyo);
        start();
    }

    @Override // io.reactivex.v
    public v.c dHY() {
        return new C0758a(this.nys.get().dIq());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bk(i, "number > 0 required");
        this.nys.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nys.get().dIq().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nys.get().dIq().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nyq, this.aNw);
        if (!this.nys.compareAndSet(nyo, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0758a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nyt = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nyu = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nyv = new io.reactivex.internal.disposables.b();
        private final c nyw;

        C0758a(c cVar) {
            this.nyw = cVar;
            this.nyv.a(this.nyt);
            this.nyv.a(this.nyu);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nyv.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyw.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nyt);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyw.a(runnable, j, timeUnit, this.nyu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
