package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nyS;
    static final RxThreadFactory nyT;
    static final int nyU = em(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nyV = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aRW;
    final AtomicReference<b> nyW;

    static {
        nyV.dispose();
        nyT = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nyS = new b(0, nyT);
        nyS.shutdown();
    }

    static int em(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nzb;
        final c[] nzc;

        b(int i, ThreadFactory threadFactory) {
            this.nzb = i;
            this.nzc = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nzc[i2] = new c(threadFactory);
            }
        }

        public c dJz() {
            int i = this.nzb;
            if (i == 0) {
                return a.nyV;
            }
            c[] cVarArr = this.nzc;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nzc) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nzb;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nyV);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0766a(this.nzc[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nyT);
    }

    public a(ThreadFactory threadFactory) {
        this.aRW = threadFactory;
        this.nyW = new AtomicReference<>(nyS);
        start();
    }

    @Override // io.reactivex.v
    public v.c dJh() {
        return new C0766a(this.nyW.get().dJz());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bj(i, "number > 0 required");
        this.nyW.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nyW.get().dJz().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nyW.get().dJz().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nyU, this.aRW);
        if (!this.nyW.compareAndSet(nyS, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0766a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nyX = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nyY = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nyZ = new io.reactivex.internal.disposables.b();
        private final c nza;

        C0766a(c cVar) {
            this.nza = cVar;
            this.nyZ.a(this.nyX);
            this.nyZ.a(this.nyY);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nyZ.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nza.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nyX);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nza.a(runnable, j, timeUnit, this.nyY);
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
