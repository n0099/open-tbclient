package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a extends v implements h {
    static final b mUv;
    static final RxThreadFactory mUw;
    static final int mUx = dy(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c mUy = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory bos;
    final AtomicReference<b> mUz;

    static {
        mUy.dispose();
        mUw = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        mUv = new b(0, mUw);
        mUv.shutdown();
    }

    static int dy(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements h {
        final int mUE;
        final c[] mUF;
        long n;

        b(int i, ThreadFactory threadFactory) {
            this.mUE = i;
            this.mUF = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.mUF[i2] = new c(threadFactory);
            }
        }

        public c dCW() {
            int i = this.mUE;
            if (i == 0) {
                return a.mUy;
            }
            c[] cVarArr = this.mUF;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.mUF) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.mUE;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.mUy);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C0811a(this.mUF[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(mUw);
    }

    public a(ThreadFactory threadFactory) {
        this.bos = threadFactory;
        this.mUz = new AtomicReference<>(mUv);
        start();
    }

    @Override // io.reactivex.v
    public v.c dCD() {
        return new C0811a(this.mUz.get().dCW());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.by(i, "number > 0 required");
        this.mUz.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mUz.get().dCW().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.mUz.get().dCW().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(mUx, this.bos);
        if (!this.mUz.compareAndSet(mUv, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0811a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e mUA = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a mUB = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e mUC = new io.reactivex.internal.disposables.e();
        private final c mUD;

        C0811a(c cVar) {
            this.mUD = cVar;
            this.mUC.a(this.mUA);
            this.mUC.a(this.mUB);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.mUC.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mUD.a(runnable, 0L, TimeUnit.MILLISECONDS, this.mUA);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.mUD.a(runnable, j, timeUnit, this.mUB);
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
