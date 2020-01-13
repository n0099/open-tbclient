package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b nyj;
    static final RxThreadFactory nyk;
    static final int nyl = ej(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nym = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aNw;
    final AtomicReference<b> nyn;

    static {
        nym.dispose();
        nyk = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nyj = new b(0, nyk);
        nyj.shutdown();
    }

    static int ej(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int nys;
        final c[] nyt;

        b(int i, ThreadFactory threadFactory) {
            this.nys = i;
            this.nyt = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nyt[i2] = new c(threadFactory);
            }
        }

        public c dIo() {
            int i = this.nys;
            if (i == 0) {
                return a.nym;
            }
            c[] cVarArr = this.nyt;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nyt) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nys;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nym);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0758a(this.nyt[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nyk);
    }

    public a(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        this.nyn = new AtomicReference<>(nyj);
        start();
    }

    @Override // io.reactivex.v
    public v.c dHW() {
        return new C0758a(this.nyn.get().dIo());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bk(i, "number > 0 required");
        this.nyn.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nyn.get().dIo().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nyn.get().dIo().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nyl, this.aNw);
        if (!this.nyn.compareAndSet(nyj, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0758a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nyo = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nyp = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nyq = new io.reactivex.internal.disposables.b();
        private final c nyr;

        C0758a(c cVar) {
            this.nyr = cVar;
            this.nyq.a(this.nyo);
            this.nyq.a(this.nyp);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nyq.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyr.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nyo);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyr.a(runnable, j, timeUnit, this.nyp);
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
