package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final int nMA = dM(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nMB = new c(new RxThreadFactory("RxComputationShutdown"));
    static final b nMy;
    static final RxThreadFactory nMz;
    final ThreadFactory bAJ;
    final AtomicReference<b> nMC;

    static {
        nMB.dispose();
        nMz = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nMy = new b(0, nMz);
        nMy.shutdown();
    }

    static int dM(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nMH;
        final c[] nMI;

        b(int i, ThreadFactory threadFactory) {
            this.nMH = i;
            this.nMI = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nMI[i2] = new c(threadFactory);
            }
        }

        public c dPO() {
            int i = this.nMH;
            if (i == 0) {
                return a.nMB;
            }
            c[] cVarArr = this.nMI;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nMI) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nMH;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nMB);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0894a(this.nMI[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nMz);
    }

    public a(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        this.nMC = new AtomicReference<>(nMy);
        start();
    }

    @Override // io.reactivex.v
    public v.c dPv() {
        return new C0894a(this.nMC.get().dPO());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bK(i, "number > 0 required");
        this.nMC.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nMC.get().dPO().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nMC.get().dPO().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nMA, this.bAJ);
        if (!this.nMC.compareAndSet(nMy, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0894a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e nMD = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a nME = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e nMF = new io.reactivex.internal.disposables.e();
        private final c nMG;

        C0894a(c cVar) {
            this.nMG = cVar;
            this.nMF.a(this.nMD);
            this.nMF.a(this.nME);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nMF.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b K(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nMG.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nMD);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nMG.a(runnable, j, timeUnit, this.nME);
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
