package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b qgo;
    static final RxThreadFactory qgp;
    static final int qgq = ek(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qgr = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qgs;
    final AtomicReference<b> qgt;

    static {
        qgr.dispose();
        qgp = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qgo = new b(0, qgp);
        qgo.shutdown();
    }

    static int ek(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int qgy;
        final c[] qgz;

        b(int i, ThreadFactory threadFactory) {
            this.qgy = i;
            this.qgz = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qgz[i2] = new c(threadFactory);
            }
        }

        public c eIi() {
            int i = this.qgy;
            if (i == 0) {
                return a.qgr;
            }
            c[] cVarArr = this.qgz;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qgz) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qgy;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qgr);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1293a(this.qgz[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qgp);
    }

    public a(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
        this.qgt = new AtomicReference<>(qgo);
        start();
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        return new C1293a(this.qgt.get().eIi());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.ce(i, "number > 0 required");
        this.qgt.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qgt.get().eIi().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qgt.get().eIi().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qgq, this.qgs);
        if (!this.qgt.compareAndSet(qgo, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1293a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qgu = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qgv = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qgw = new io.reactivex.internal.disposables.e();
        private final c qgx;

        C1293a(c cVar) {
            this.qgx = cVar;
            this.qgw.a(this.qgu);
            this.qgw.a(this.qgv);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qgw.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qgx.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qgu);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qgx.a(runnable, j, timeUnit, this.qgv);
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
