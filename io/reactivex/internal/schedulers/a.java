package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class a extends v implements h {
    static final b pPl;
    static final RxThreadFactory pPm;
    static final int pPn = el(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c pPo = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory pPp;
    final AtomicReference<b> pPq;

    static {
        pPo.dispose();
        pPm = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        pPl = new b(0, pPm);
        pPl.shutdown();
    }

    static int el(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class b implements h {
        long n;
        final int pPv;
        final c[] pPw;

        b(int i, ThreadFactory threadFactory) {
            this.pPv = i;
            this.pPw = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pPw[i2] = new c(threadFactory);
            }
        }

        public c eAT() {
            int i = this.pPv;
            if (i == 0) {
                return a.pPo;
            }
            c[] cVarArr = this.pPw;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pPw) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.pPv;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.pPo);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1074a(this.pPw[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(pPm);
    }

    public a(ThreadFactory threadFactory) {
        this.pPp = threadFactory;
        this.pPq = new AtomicReference<>(pPl);
        start();
    }

    @Override // io.reactivex.v
    public v.c eAA() {
        return new C1074a(this.pPq.get().eAT());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cc(i, "number > 0 required");
        this.pPq.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.pPq.get().eAT().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.pPq.get().eAT().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(pPn, this.pPp);
        if (!this.pPq.compareAndSet(pPl, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1074a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e pPr = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a pPs = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e pPt = new io.reactivex.internal.disposables.e();
        private final c pPu;

        C1074a(c cVar) {
            this.pPu = cVar;
            this.pPt.a(this.pPr);
            this.pPt.a(this.pPs);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.pPt.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pPu.a(runnable, 0L, TimeUnit.MILLISECONDS, this.pPr);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.pPu.a(runnable, j, timeUnit, this.pPs);
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
