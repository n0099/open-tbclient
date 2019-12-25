package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class a extends v implements h {
    static final b mWa;
    static final RxThreadFactory mWb;
    static final int mWc = ei(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c mWd = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aME;
    final AtomicReference<b> mWe;

    static {
        mWd.dispose();
        mWb = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        mWa = new b(0, mWb);
        mWa.shutdown();
    }

    static int ei(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b implements h {
        final int mWj;
        final c[] mWk;
        long n;

        b(int i, ThreadFactory threadFactory) {
            this.mWj = i;
            this.mWk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.mWk[i2] = new c(threadFactory);
            }
        }

        public c dEe() {
            int i = this.mWj;
            if (i == 0) {
                return a.mWd;
            }
            c[] cVarArr = this.mWk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.mWk) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.mWj;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.mWd);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0714a(this.mWk[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(mWb);
    }

    public a(ThreadFactory threadFactory) {
        this.aME = threadFactory;
        this.mWe = new AtomicReference<>(mWa);
        start();
    }

    @Override // io.reactivex.v
    public v.c dDP() {
        return new C0714a(this.mWe.get().dEe());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.be(i, "number > 0 required");
        this.mWe.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mWe.get().dEe().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.mWe.get().dEe().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(mWc, this.aME);
        if (!this.mWe.compareAndSet(mWa, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0714a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b mWf = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a mWg = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b mWh = new io.reactivex.internal.disposables.b();
        private final c mWi;

        C0714a(c cVar) {
            this.mWi = cVar;
            this.mWh.a(this.mWf);
            this.mWh.a(this.mWg);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.mWh.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mWi.a(runnable, 0L, TimeUnit.MILLISECONDS, this.mWf);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mWi.a(runnable, j, timeUnit, this.mWg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
