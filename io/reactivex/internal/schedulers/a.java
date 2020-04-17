package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b mUs;
    static final RxThreadFactory mUt;
    static final int mUu = dy(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c mUv = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory bon;
    final AtomicReference<b> mUw;

    static {
        mUv.dispose();
        mUt = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        mUs = new b(0, mUt);
        mUs.shutdown();
    }

    static int dy(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        final int mUB;
        final c[] mUC;
        long n;

        b(int i, ThreadFactory threadFactory) {
            this.mUB = i;
            this.mUC = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.mUC[i2] = new c(threadFactory);
            }
        }

        public c dCZ() {
            int i = this.mUB;
            if (i == 0) {
                return a.mUv;
            }
            c[] cVarArr = this.mUC;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.mUC) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.mUB;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.mUv);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0790a(this.mUC[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(mUt);
    }

    public a(ThreadFactory threadFactory) {
        this.bon = threadFactory;
        this.mUw = new AtomicReference<>(mUs);
        start();
    }

    @Override // io.reactivex.v
    public v.c dCG() {
        return new C0790a(this.mUw.get().dCZ());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.by(i, "number > 0 required");
        this.mUw.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mUw.get().dCZ().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.mUw.get().dCZ().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(mUu, this.bon);
        if (!this.mUw.compareAndSet(mUs, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0790a extends v.c {
        volatile boolean disposed;
        private final c mUA;
        private final io.reactivex.internal.disposables.e mUx = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a mUy = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e mUz = new io.reactivex.internal.disposables.e();

        C0790a(c cVar) {
            this.mUA = cVar;
            this.mUz.a(this.mUx);
            this.mUz.a(this.mUy);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.mUz.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mUA.a(runnable, 0L, TimeUnit.MILLISECONDS, this.mUx);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mUA.a(runnable, j, timeUnit, this.mUy);
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
