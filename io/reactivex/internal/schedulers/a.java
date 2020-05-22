package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final int npA = dD(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c npB = new c(new RxThreadFactory("RxComputationShutdown"));
    static final b npy;
    static final RxThreadFactory npz;
    final ThreadFactory bvS;
    final AtomicReference<b> npC;

    static {
        npB.dispose();
        npz = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        npy = new b(0, npz);
        npy.shutdown();
    }

    static int dD(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int npH;
        final c[] npI;

        b(int i, ThreadFactory threadFactory) {
            this.npH = i;
            this.npI = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.npI[i2] = new c(threadFactory);
            }
        }

        public c dKQ() {
            int i = this.npH;
            if (i == 0) {
                return a.npB;
            }
            c[] cVarArr = this.npI;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.npI) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.npH;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.npB);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0873a(this.npI[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(npz);
    }

    public a(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        this.npC = new AtomicReference<>(npy);
        start();
    }

    @Override // io.reactivex.v
    public v.c dKx() {
        return new C0873a(this.npC.get().dKQ());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bD(i, "number > 0 required");
        this.npC.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.npC.get().dKQ().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.npC.get().dKQ().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(npA, this.bvS);
        if (!this.npC.compareAndSet(npy, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0873a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e npD = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a npE = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e npF = new io.reactivex.internal.disposables.e();
        private final c npG;

        C0873a(c cVar) {
            this.npG = cVar;
            this.npF.a(this.npD);
            this.npF.a(this.npE);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.npF.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b K(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.npG.a(runnable, 0L, TimeUnit.MILLISECONDS, this.npD);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.npG.a(runnable, j, timeUnit, this.npE);
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
