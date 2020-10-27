package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class a extends v implements h {
    static final b pFR;
    static final RxThreadFactory pFS;
    static final int pFT = ei(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c pFU = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory pFV;
    final AtomicReference<b> pFW;

    static {
        pFU.dispose();
        pFS = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        pFR = new b(0, pFS);
        pFR.shutdown();
    }

    static int ei(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class b implements h {
        long n;
        final int pGb;
        final c[] pGc;

        b(int i, ThreadFactory threadFactory) {
            this.pGb = i;
            this.pGc = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pGc[i2] = new c(threadFactory);
            }
        }

        public c exe() {
            int i = this.pGb;
            if (i == 0) {
                return a.pFU;
            }
            c[] cVarArr = this.pGc;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pGc) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.pGb;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.pFU);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1054a(this.pGc[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(pFS);
    }

    public a(ThreadFactory threadFactory) {
        this.pFV = threadFactory;
        this.pFW = new AtomicReference<>(pFR);
        start();
    }

    @Override // io.reactivex.v
    public v.c ewL() {
        return new C1054a(this.pFW.get().exe());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bX(i, "number > 0 required");
        this.pFW.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pFW.get().exe().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pFW.get().exe().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(pFT, this.pFV);
        if (!this.pFW.compareAndSet(pFR, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1054a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e pFX = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a pFY = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e pFZ = new io.reactivex.internal.disposables.e();
        private final c pGa;

        C1054a(c cVar) {
            this.pGa = cVar;
            this.pFZ.a(this.pFX);
            this.pFZ.a(this.pFY);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.pFZ.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pGa.a(runnable, 0L, TimeUnit.MILLISECONDS, this.pFX);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pGa.a(runnable, j, timeUnit, this.pFY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
