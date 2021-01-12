package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b qgn;
    static final RxThreadFactory qgo;
    static final int qgp = ek(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qgq = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qgr;
    final AtomicReference<b> qgs;

    static {
        qgq.dispose();
        qgo = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qgn = new b(0, qgo);
        qgn.shutdown();
    }

    static int ek(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int qgx;
        final c[] qgy;

        b(int i, ThreadFactory threadFactory) {
            this.qgx = i;
            this.qgy = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qgy[i2] = new c(threadFactory);
            }
        }

        public c eIi() {
            int i = this.qgx;
            if (i == 0) {
                return a.qgq;
            }
            c[] cVarArr = this.qgy;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qgy) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qgx;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qgq);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1293a(this.qgy[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qgo);
    }

    public a(ThreadFactory threadFactory) {
        this.qgr = threadFactory;
        this.qgs = new AtomicReference<>(qgn);
        start();
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        return new C1293a(this.qgs.get().eIi());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.ce(i, "number > 0 required");
        this.qgs.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qgs.get().eIi().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qgs.get().eIi().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qgp, this.qgr);
        if (!this.qgs.compareAndSet(qgn, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1293a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qgt = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qgu = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qgv = new io.reactivex.internal.disposables.e();
        private final c qgw;

        C1293a(c cVar) {
            this.qgw = cVar;
            this.qgv.a(this.qgt);
            this.qgv.a(this.qgu);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qgv.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qgw.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qgt);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qgw.a(runnable, j, timeUnit, this.qgu);
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
