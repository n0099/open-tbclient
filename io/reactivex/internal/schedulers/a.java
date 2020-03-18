package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nAQ;
    static final RxThreadFactory nAR;
    static final int nAS = en(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nAT = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aSk;
    final AtomicReference<b> nAU;

    static {
        nAT.dispose();
        nAR = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nAQ = new b(0, nAR);
        nAQ.shutdown();
    }

    static int en(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nAZ;
        final c[] nBa;

        b(int i, ThreadFactory threadFactory) {
            this.nAZ = i;
            this.nBa = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nBa[i2] = new c(threadFactory);
            }
        }

        public c dKa() {
            int i = this.nAZ;
            if (i == 0) {
                return a.nAT;
            }
            c[] cVarArr = this.nBa;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nBa) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nAZ;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nAT);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0767a(this.nBa[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nAR);
    }

    public a(ThreadFactory threadFactory) {
        this.aSk = threadFactory;
        this.nAU = new AtomicReference<>(nAQ);
        start();
    }

    @Override // io.reactivex.v
    public v.c dJI() {
        return new C0767a(this.nAU.get().dKa());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bj(i, "number > 0 required");
        this.nAU.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nAU.get().dKa().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nAU.get().dKa().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nAS, this.aSk);
        if (!this.nAU.compareAndSet(nAQ, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0767a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nAV = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nAW = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nAX = new io.reactivex.internal.disposables.b();
        private final c nAY;

        C0767a(c cVar) {
            this.nAY = cVar;
            this.nAX.a(this.nAV);
            this.nAX.a(this.nAW);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nAX.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nAY.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nAV);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nAY.a(runnable, j, timeUnit, this.nAW);
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
