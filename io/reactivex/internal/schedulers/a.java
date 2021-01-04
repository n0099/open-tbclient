package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class a extends v implements h {
    static final b qjh;
    static final RxThreadFactory qji;
    static final int qjj = ei(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qjk = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qjl;
    final AtomicReference<b> qjm;

    static {
        qjk.dispose();
        qji = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qjh = new b(0, qji);
        qjh.shutdown();
    }

    static int ei(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b implements h {
        long n;
        final int qjr;
        final c[] qjs;

        b(int i, ThreadFactory threadFactory) {
            this.qjr = i;
            this.qjs = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qjs[i2] = new c(threadFactory);
            }
        }

        public c eLu() {
            int i = this.qjr;
            if (i == 0) {
                return a.qjk;
            }
            c[] cVarArr = this.qjs;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qjs) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qjr;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qjk);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1269a(this.qjs[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qji);
    }

    public a(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
        this.qjm = new AtomicReference<>(qjh);
        start();
    }

    @Override // io.reactivex.v
    public v.c eLe() {
        return new C1269a(this.qjm.get().eLu());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cd(i, "number > 0 required");
        this.qjm.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qjm.get().eLu().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qjm.get().eLu().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qjj, this.qjl);
        if (!this.qjm.compareAndSet(qjh, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1269a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qjn = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qjo = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qjp = new io.reactivex.internal.disposables.e();
        private final c qjq;

        C1269a(c cVar) {
            this.qjq = cVar;
            this.qjp.a(this.qjn);
            this.qjp.a(this.qjo);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qjp.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qjq.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qjn);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qjq.a(runnable, j, timeUnit, this.qjo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
