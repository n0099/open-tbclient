package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b ope;
    static final RxThreadFactory opf;
    static final int opg = dW(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c oph = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory opi;
    final AtomicReference<b> opj;

    static {
        oph.dispose();
        opf = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        ope = new b(0, opf);
        ope.shutdown();
    }

    static int dW(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        long n;
        final int opo;
        final c[] opp;

        b(int i, ThreadFactory threadFactory) {
            this.opo = i;
            this.opp = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.opp[i2] = new c(threadFactory);
            }
        }

        public c efn() {
            int i = this.opo;
            if (i == 0) {
                return a.oph;
            }
            c[] cVarArr = this.opp;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.opp) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.opo;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.oph);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0967a(this.opp[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(opf);
    }

    public a(ThreadFactory threadFactory) {
        this.opi = threadFactory;
        this.opj = new AtomicReference<>(ope);
        start();
    }

    @Override // io.reactivex.v
    public v.c eeU() {
        return new C0967a(this.opj.get().efn());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.bJ(i, "number > 0 required");
        this.opj.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.opj.get().efn().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.opj.get().efn().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(opg, this.opi);
        if (!this.opj.compareAndSet(ope, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0967a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e opk = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a opl = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e opm = new io.reactivex.internal.disposables.e();
        private final c opn;

        C0967a(c cVar) {
            this.opn = cVar;
            this.opm.a(this.opk);
            this.opm.a(this.opl);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.opm.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.opn.a(runnable, 0L, TimeUnit.MILLISECONDS, this.opk);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.opn.a(runnable, j, timeUnit, this.opl);
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
