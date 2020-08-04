package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nVi;
    static final RxThreadFactory nVj;
    static final int nVk = dO(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nVl = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory nVm;
    final AtomicReference<b> nVn;

    static {
        nVl.dispose();
        nVj = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nVi = new b(0, nVj);
        nVi.shutdown();
    }

    static int dO(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nVs;
        final c[] nVt;

        b(int i, ThreadFactory threadFactory) {
            this.nVs = i;
            this.nVt = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nVt[i2] = new c(threadFactory);
            }
        }

        public c dTl() {
            int i = this.nVs;
            if (i == 0) {
                return a.nVl;
            }
            c[] cVarArr = this.nVt;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nVt) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nVs;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nVl);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0909a(this.nVt[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nVj);
    }

    public a(ThreadFactory threadFactory) {
        this.nVm = threadFactory;
        this.nVn = new AtomicReference<>(nVi);
        start();
    }

    @Override // io.reactivex.v
    public v.c dSS() {
        return new C0909a(this.nVn.get().dTl());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bL(i, "number > 0 required");
        this.nVn.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nVn.get().dTl().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nVn.get().dTl().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nVk, this.nVm);
        if (!this.nVn.compareAndSet(nVi, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0909a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e nVo = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a nVp = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e nVq = new io.reactivex.internal.disposables.e();
        private final c nVr;

        C0909a(c cVar) {
            this.nVr = cVar;
            this.nVq.a(this.nVo);
            this.nVq.a(this.nVp);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nVq.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b J(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nVr.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nVo);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nVr.a(runnable, j, timeUnit, this.nVp);
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
