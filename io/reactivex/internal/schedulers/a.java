package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b pQO;
    static final RxThreadFactory pQP;
    static final int pQQ = em(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c pQR = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory pQS;
    final AtomicReference<b> pQT;

    static {
        pQR.dispose();
        pQP = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        pQO = new b(0, pQP);
        pQO.shutdown();
    }

    static int em(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int pQY;
        final c[] pQZ;

        b(int i, ThreadFactory threadFactory) {
            this.pQY = i;
            this.pQZ = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pQZ[i2] = new c(threadFactory);
            }
        }

        public c eAU() {
            int i = this.pQY;
            if (i == 0) {
                return a.pQR;
            }
            c[] cVarArr = this.pQZ;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pQZ) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.pQY;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.pQR);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1077a(this.pQZ[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(pQP);
    }

    public a(ThreadFactory threadFactory) {
        this.pQS = threadFactory;
        this.pQT = new AtomicReference<>(pQO);
        start();
    }

    @Override // io.reactivex.v
    public v.c eAB() {
        return new C1077a(this.pQT.get().eAU());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.ca(i, "number > 0 required");
        this.pQT.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pQT.get().eAU().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pQT.get().eAU().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(pQQ, this.pQS);
        if (!this.pQT.compareAndSet(pQO, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1077a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e pQU = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a pQV = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e pQW = new io.reactivex.internal.disposables.e();
        private final c pQX;

        C1077a(c cVar) {
            this.pQX = cVar;
            this.pQW.a(this.pQU);
            this.pQW.a(this.pQV);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.pQW.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pQX.a(runnable, 0L, TimeUnit.MILLISECONDS, this.pQU);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pQX.a(runnable, j, timeUnit, this.pQV);
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
