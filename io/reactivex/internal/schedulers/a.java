package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a extends v implements h {
    static final b qru;
    static final RxThreadFactory qrv;
    static final int qrw = eh(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qrx = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qry;
    final AtomicReference<b> qrz;

    static {
        qrx.dispose();
        qrv = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qru = new b(0, qrv);
        qru.shutdown();
    }

    static int eh(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements h {
        long n;
        final int qrE;
        final c[] qrF;

        b(int i, ThreadFactory threadFactory) {
            this.qrE = i;
            this.qrF = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qrF[i2] = new c(threadFactory);
            }
        }

        public c eKo() {
            int i = this.qrE;
            if (i == 0) {
                return a.qrx;
            }
            c[] cVarArr = this.qrF;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qrF) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qrE;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qrx);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1287a(this.qrF[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qrv);
    }

    public a(ThreadFactory threadFactory) {
        this.qry = threadFactory;
        this.qrz = new AtomicReference<>(qru);
        start();
    }

    @Override // io.reactivex.v
    public v.c eJY() {
        return new C1287a(this.qrz.get().eKo());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.ck(i, "number > 0 required");
        this.qrz.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qrz.get().eKo().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qrz.get().eKo().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qrw, this.qry);
        if (!this.qrz.compareAndSet(qru, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1287a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qrA = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qrB = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qrC = new io.reactivex.internal.disposables.e();
        private final c qrD;

        C1287a(c cVar) {
            this.qrD = cVar;
            this.qrC.a(this.qrA);
            this.qrC.a(this.qrB);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qrC.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qrD.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qrA);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qrD.a(runnable, j, timeUnit, this.qrB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
