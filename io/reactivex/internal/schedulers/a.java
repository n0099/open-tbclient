package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nyQ;
    static final RxThreadFactory nyR;
    static final int nyS = em(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nyT = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aRV;
    final AtomicReference<b> nyU;

    static {
        nyT.dispose();
        nyR = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nyQ = new b(0, nyR);
        nyQ.shutdown();
    }

    static int em(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nyZ;
        final c[] nza;

        b(int i, ThreadFactory threadFactory) {
            this.nyZ = i;
            this.nza = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nza[i2] = new c(threadFactory);
            }
        }

        public c dJx() {
            int i = this.nyZ;
            if (i == 0) {
                return a.nyT;
            }
            c[] cVarArr = this.nza;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nza) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nyZ;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nyT);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0766a(this.nza[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nyR);
    }

    public a(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
        this.nyU = new AtomicReference<>(nyQ);
        start();
    }

    @Override // io.reactivex.v
    public v.c dJf() {
        return new C0766a(this.nyU.get().dJx());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bj(i, "number > 0 required");
        this.nyU.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nyU.get().dJx().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nyU.get().dJx().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nyS, this.aRV);
        if (!this.nyU.compareAndSet(nyQ, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0766a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nyV = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nyW = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nyX = new io.reactivex.internal.disposables.b();
        private final c nyY;

        C0766a(c cVar) {
            this.nyY = cVar;
            this.nyX.a(this.nyV);
            this.nyX.a(this.nyW);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nyX.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyY.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nyV);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nyY.a(runnable, j, timeUnit, this.nyW);
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
