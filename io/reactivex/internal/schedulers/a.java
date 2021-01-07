package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a extends v implements h {
    static final b qkP;
    static final RxThreadFactory qkQ;
    static final int qkR = ek(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c qkS = new c(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory qkT;
    final AtomicReference<b> qkU;

    static {
        qkS.dispose();
        qkQ = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        qkP = new b(0, qkQ);
        qkP.shutdown();
    }

    static int ek(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements h {
        long n;
        final int qkZ;
        final c[] qla;

        b(int i, ThreadFactory threadFactory) {
            this.qkZ = i;
            this.qla = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qla[i2] = new c(threadFactory);
            }
        }

        public c eLY() {
            int i = this.qkZ;
            if (i == 0) {
                return a.qkS;
            }
            c[] cVarArr = this.qla;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qla) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.h
        public void a(int i, h.a aVar) {
            int i2 = this.qkZ;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    aVar.a(i3, a.qkS);
                }
                return;
            }
            int i4 = ((int) this.n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                aVar.a(i5, new C1310a(this.qla[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.n = i4;
        }
    }

    public a() {
        this(qkQ);
    }

    public a(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
        this.qkU = new AtomicReference<>(qkP);
        start();
    }

    @Override // io.reactivex.v
    public v.c eLI() {
        return new C1310a(this.qkU.get().eLY());
    }

    @Override // io.reactivex.internal.schedulers.h
    public void a(int i, h.a aVar) {
        io.reactivex.internal.functions.a.cd(i, "number > 0 required");
        this.qkU.get().a(i, aVar);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.qkU.get().eLY().b(runnable, j, timeUnit);
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.qkU.get().eLY().a(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.v
    public void start() {
        b bVar = new b(qkR, this.qkT);
        if (!this.qkU.compareAndSet(qkP, bVar)) {
            bVar.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1310a extends v.c {
        volatile boolean disposed;
        private final io.reactivex.internal.disposables.e qkV = new io.reactivex.internal.disposables.e();
        private final io.reactivex.disposables.a qkW = new io.reactivex.disposables.a();
        private final io.reactivex.internal.disposables.e qkX = new io.reactivex.internal.disposables.e();
        private final c qkY;

        C1310a(c cVar) {
            this.qkY = cVar;
            this.qkX.a(this.qkV);
            this.qkX.a(this.qkW);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.qkX.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qkY.a(runnable, 0L, TimeUnit.MILLISECONDS, this.qkV);
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.qkY.a(runnable, j, timeUnit, this.qkW);
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
