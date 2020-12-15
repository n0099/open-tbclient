package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class a extends v implements h {
    static final b pHE;
    static final RxThreadFactory pHF;
    static final int pHG = ej(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c pHH = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory pHI;
    final AtomicReference<b> pHJ;

    static {
        pHH.dispose();
        pHF = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        pHE = new b(0, pHF);
        pHE.shutdown();
    }

    static int ej(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class b implements h {
        long n;
        final int pHO;
        final c[] pHP;

        b(int i, ThreadFactory threadFactory) {
            this.pHO = i;
            this.pHP = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pHP[i2] = new c(threadFactory);
            }
        }

        public c eDm() {
            int i = this.pHO;
            if (i == 0) {
                return a.pHH;
            }
            c[] cVarArr = this.pHP;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pHP) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.pHO;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.pHH);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1051a(this.pHP[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(pHF);
    }

    public a(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
        this.pHJ = new AtomicReference<>(pHE);
        start();
    }

    @Override // io.reactivex.v
    public v.c eCW() {
        return new C1051a(this.pHJ.get().eDm());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cb(i, "number > 0 required");
        this.pHJ.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pHJ.get().eDm().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pHJ.get().eDm().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(pHG, this.pHI);
        if (!this.pHJ.compareAndSet(pHE, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1051a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e pHK = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a pHL = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e pHM = new io.reactivex.internal.disposables.e();
        private final c pHN;

        C1051a(c cVar) {
            this.pHN = cVar;
            this.pHM.a(this.pHK);
            this.pHM.a(this.pHL);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.pHM.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b H(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pHN.a(runnable, 0L, TimeUnit.MILLISECONDS, this.pHK);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pHN.a(runnable, j, timeUnit, this.pHL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
