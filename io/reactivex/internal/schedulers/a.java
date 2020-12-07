package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class a extends v implements h {
    static final b pHC;
    static final RxThreadFactory pHD;
    static final int pHE = ej(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c pHF = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory pHG;
    final AtomicReference<b> pHH;

    static {
        pHF.dispose();
        pHD = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        pHC = new b(0, pHD);
        pHC.shutdown();
    }

    static int ej(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class b implements h {
        long n;
        final int pHM;
        final c[] pHN;

        b(int i, ThreadFactory threadFactory) {
            this.pHM = i;
            this.pHN = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pHN[i2] = new c(threadFactory);
            }
        }

        public c eDl() {
            int i = this.pHM;
            if (i == 0) {
                return a.pHF;
            }
            c[] cVarArr = this.pHN;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pHN) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.pHM;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.pHF);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1051a(this.pHN[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(pHD);
    }

    public a(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
        this.pHH = new AtomicReference<>(pHC);
        start();
    }

    @Override // io.reactivex.v
    public v.c eCV() {
        return new C1051a(this.pHH.get().eDl());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cb(i, "number > 0 required");
        this.pHH.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pHH.get().eDl().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pHH.get().eDl().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(pHE, this.pHG);
        if (!this.pHH.compareAndSet(pHC, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1051a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e pHI = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a pHJ = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e pHK = new io.reactivex.internal.disposables.e();
        private final c pHL;

        C1051a(c cVar) {
            this.pHL = cVar;
            this.pHK.a(this.pHI);
            this.pHK.a(this.pHJ);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.pHK.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b H(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pHL.a(runnable, 0L, TimeUnit.MILLISECONDS, this.pHI);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pHL.a(runnable, j, timeUnit, this.pHJ);
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
