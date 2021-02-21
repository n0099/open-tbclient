package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b qqS;
    static final RxThreadFactory qqT;
    static final int qqU = ei(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qqV = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qqW;
    final AtomicReference<b> qqX;

    static {
        qqV.dispose();
        qqT = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qqS = new b(0, qqT);
        qqS.shutdown();
    }

    static int ei(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int qrc;
        final c[] qrd;

        b(int i, ThreadFactory threadFactory) {
            this.qrc = i;
            this.qrd = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qrd[i2] = new c(threadFactory);
            }
        }

        public c eKG() {
            int i = this.qrc;
            if (i == 0) {
                return a.qqV;
            }
            c[] cVarArr = this.qrd;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qrd) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qrc;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qqV);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1305a(this.qrd[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qqT);
    }

    public a(ThreadFactory threadFactory) {
        this.qqW = threadFactory;
        this.qqX = new AtomicReference<>(qqS);
        start();
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        return new C1305a(this.qqX.get().eKG());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cl(i, "number > 0 required");
        this.qqX.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qqX.get().eKG().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qqX.get().eKG().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qqU, this.qqW);
        if (!this.qqX.compareAndSet(qqS, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1305a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qqY = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qqZ = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qra = new io.reactivex.internal.disposables.e();
        private final c qrb;

        C1305a(c cVar) {
            this.qrb = cVar;
            this.qra.a(this.qqY);
            this.qra.a(this.qqZ);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qra.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b E(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qrb.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qqY);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qrb.a(runnable, j, timeUnit, this.qqZ);
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
