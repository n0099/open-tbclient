package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b qqs;
    static final RxThreadFactory qqt;
    static final int qqu = eh(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qqv = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qqw;
    final AtomicReference<b> qqx;

    static {
        qqv.dispose();
        qqt = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qqs = new b(0, qqt);
        qqs.shutdown();
    }

    static int eh(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int qqC;
        final c[] qqD;

        b(int i, ThreadFactory threadFactory) {
            this.qqC = i;
            this.qqD = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qqD[i2] = new c(threadFactory);
            }
        }

        public c eKy() {
            int i = this.qqC;
            if (i == 0) {
                return a.qqv;
            }
            c[] cVarArr = this.qqD;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qqD) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qqC;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qqv);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1303a(this.qqD[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qqt);
    }

    public a(ThreadFactory threadFactory) {
        this.qqw = threadFactory;
        this.qqx = new AtomicReference<>(qqs);
        start();
    }

    @Override // io.reactivex.v
    public v.c eKi() {
        return new C1303a(this.qqx.get().eKy());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cl(i, "number > 0 required");
        this.qqx.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qqx.get().eKy().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qqx.get().eKy().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qqu, this.qqw);
        if (!this.qqx.compareAndSet(qqs, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1303a extends v.c {
        volatile boolean disposed;
        private final c qqB;
        private final io.reactivex.internal.disposables.e qqy = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qqz = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qqA = new io.reactivex.internal.disposables.e();

        C1303a(c cVar) {
            this.qqB = cVar;
            this.qqA.a(this.qqy);
            this.qqA.a(this.qqz);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qqA.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b E(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qqB.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qqy);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qqB.a(runnable, j, timeUnit, this.qqz);
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
