package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nVg;
    static final RxThreadFactory nVh;
    static final int nVi = dO(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nVj = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory nVk;
    final AtomicReference<b> nVl;

    static {
        nVj.dispose();
        nVh = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nVg = new b(0, nVh);
        nVg.shutdown();
    }

    static int dO(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nVq;
        final c[] nVr;

        b(int i, ThreadFactory threadFactory) {
            this.nVq = i;
            this.nVr = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nVr[i2] = new c(threadFactory);
            }
        }

        public c dTk() {
            int i = this.nVq;
            if (i == 0) {
                return a.nVj;
            }
            c[] cVarArr = this.nVr;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nVr) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nVq;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nVj);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0909a(this.nVr[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nVh);
    }

    public a(ThreadFactory threadFactory) {
        this.nVk = threadFactory;
        this.nVl = new AtomicReference<>(nVg);
        start();
    }

    @Override // io.reactivex.v
    public v.c dSR() {
        return new C0909a(this.nVl.get().dTk());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bL(i, "number > 0 required");
        this.nVl.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nVl.get().dTk().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nVl.get().dTk().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nVi, this.nVk);
        if (!this.nVl.compareAndSet(nVg, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0909a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e nVm = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a nVn = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e nVo = new io.reactivex.internal.disposables.e();
        private final c nVp;

        C0909a(c cVar) {
            this.nVp = cVar;
            this.nVo.a(this.nVm);
            this.nVo.a(this.nVn);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nVo.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b J(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nVp.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nVm);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nVp.a(runnable, j, timeUnit, this.nVn);
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
