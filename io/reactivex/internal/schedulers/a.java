package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b nzd;
    static final RxThreadFactory nze;
    static final int nzf = em(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c nzg = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory aRX;
    final AtomicReference<b> nzh;

    static {
        nzg.dispose();
        nze = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        nzd = new b(0, nze);
        nzd.shutdown();
    }

    static int em(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int nzm;
        final c[] nzn;

        b(int i, ThreadFactory threadFactory) {
            this.nzm = i;
            this.nzn = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nzn[i2] = new c(threadFactory);
            }
        }

        public c dJA() {
            int i = this.nzm;
            if (i == 0) {
                return a.nzg;
            }
            c[] cVarArr = this.nzn;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nzn) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.nzm;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.nzg);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0766a(this.nzn[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(nze);
    }

    public a(ThreadFactory threadFactory) {
        this.aRX = threadFactory;
        this.nzh = new AtomicReference<>(nzd);
        start();
    }

    @Override // io.reactivex.v
    public v.c dJi() {
        return new C0766a(this.nzh.get().dJA());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bj(i, "number > 0 required");
        this.nzh.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.nzh.get().dJA().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.nzh.get().dJA().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(nzf, this.aRX);
        if (!this.nzh.compareAndSet(nzd, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0766a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.b nzi = new io.reactivex.internal.disposables.b();
        private final io.reactivex.disposables.a nzj = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.b nzk = new io.reactivex.internal.disposables.b();
        private final c nzl;

        C0766a(c cVar) {
            this.nzl = cVar;
            this.nzk.a(this.nzi);
            this.nzk.a(this.nzj);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.nzk.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nzl.a(runnable, 0L, TimeUnit.MILLISECONDS, this.nzi);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.nzl.a(runnable, j, timeUnit, this.nzj);
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
