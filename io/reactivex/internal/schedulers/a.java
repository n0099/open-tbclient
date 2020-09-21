package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class a extends v implements h {
    static final b ozf;
    static final RxThreadFactory ozg;
    static final int ozh = ea(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c ozi = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory ozj;
    final AtomicReference<b> ozk;

    static {
        ozi.dispose();
        ozg = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        ozf = new b(0, ozg);
        ozf.shutdown();
    }

    static int ea(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class b implements h {
        long n;
        final int ozp;
        final c[] ozq;

        b(int i, ThreadFactory threadFactory) {
            this.ozp = i;
            this.ozq = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.ozq[i2] = new c(threadFactory);
            }
        }

        public c ejt() {
            int i = this.ozp;
            if (i == 0) {
                return a.ozi;
            }
            c[] cVarArr = this.ozq;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.ozq) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.ozp;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.ozi);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0964a(this.ozq[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(ozg);
    }

    public a(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
        this.ozk = new AtomicReference<>(ozf);
        start();
    }

    @Override // io.reactivex.v
    public v.c eja() {
        return new C0964a(this.ozk.get().ejt());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bM(i, "number > 0 required");
        this.ozk.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.ozk.get().ejt().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.ozk.get().ejt().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(ozh, this.ozj);
        if (!this.ozk.compareAndSet(ozf, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0964a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e ozl = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a ozm = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e ozn = new io.reactivex.internal.disposables.e();
        private final c ozo;

        C0964a(c cVar) {
            this.ozo = cVar;
            this.ozn.a(this.ozl);
            this.ozn.a(this.ozm);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.ozn.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.ozo.a(runnable, 0L, TimeUnit.MILLISECONDS, this.ozl);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.ozo.a(runnable, j, timeUnit, this.ozm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
