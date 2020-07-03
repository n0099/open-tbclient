package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nMv;
    static final RxThreadFactory nMw;
    static final int nMx = dM(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nMy = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory bAJ;
    final AtomicReference<b> nMz;

    static {
        nMy.dispose();
        nMw = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nMv = new b(0, nMw);
        nMv.shutdown();
    }

    static int dM(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nME;
        final c[] nMF;

        b(int i, ThreadFactory threadFactory) {
            this.nME = i;
            this.nMF = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nMF[i2] = new c(threadFactory);
            }
        }

        public c dPK() {
            int i = this.nME;
            if (i == 0) {
                return a.nMy;
            }
            c[] cVarArr = this.nMF;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nMF) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nME;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nMy);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0893a(this.nMF[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nMw);
    }

    public a(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        this.nMz = new AtomicReference<>(nMv);
        start();
    }

    @Override // io.reactivex.v
    public v.c dPr() {
        return new C0893a(this.nMz.get().dPK());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bK(i, "number > 0 required");
        this.nMz.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nMz.get().dPK().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nMz.get().dPK().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nMx, this.bAJ);
        if (!this.nMz.compareAndSet(nMv, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0893a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e nMA = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a nMB = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e nMC = new io.reactivex.internal.disposables.e();
        private final c nMD;

        C0893a(c cVar) {
            this.nMD = cVar;
            this.nMC.a(this.nMA);
            this.nMC.a(this.nMB);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nMC.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b K(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nMD.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nMA);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nMD.a(runnable, j, timeUnit, this.nMB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
