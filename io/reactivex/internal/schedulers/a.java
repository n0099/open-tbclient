package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b opx;
    static final RxThreadFactory opy;
    final ThreadFactory opB;
    final AtomicReference<b> opC;
    static final int opz = dW(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c opA = new c(new RxThreadFactory("RxComputationShutdown"));

    static {
        opA.dispose();
        opy = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        opx = new b(0, opy);
        opx.shutdown();
    }

    static int dW(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int opH;
        final c[] opI;

        b(int i, ThreadFactory threadFactory) {
            this.opH = i;
            this.opI = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.opI[i2] = new c(threadFactory);
            }
        }

        public c efw() {
            int i = this.opH;
            if (i == 0) {
                return a.opA;
            }
            c[] cVarArr = this.opI;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.opI) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.opH;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.opA);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0967a(this.opI[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(opy);
    }

    public a(ThreadFactory threadFactory) {
        this.opB = threadFactory;
        this.opC = new AtomicReference<>(opx);
        start();
    }

    @Override // io.reactivex.v
    public v.c efd() {
        return new C0967a(this.opC.get().efw());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bI(i, "number > 0 required");
        this.opC.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.opC.get().efw().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.opC.get().efw().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(opz, this.opB);
        if (!this.opC.compareAndSet(opx, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0967a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e opD = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a opE = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e opF = new io.reactivex.internal.disposables.e();
        private final c opG;

        C0967a(c cVar) {
            this.opG = cVar;
            this.opF.a(this.opD);
            this.opF.a(this.opE);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.opF.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.opG.a(runnable, 0L, TimeUnit.MILLISECONDS, this.opD);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.opG.a(runnable, j, timeUnit, this.opE);
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
