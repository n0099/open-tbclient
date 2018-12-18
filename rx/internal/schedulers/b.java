package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iKK;
    static final c iKL;
    static final C0424b iKM;
    final ThreadFactory ahS;
    final AtomicReference<C0424b> iKx = new AtomicReference<>(iKM);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iKK = intValue;
        iKL = new c(RxThreadFactory.NONE);
        iKL.unsubscribe();
        iKM = new C0424b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0424b {
        final int iKS;
        final c[] iKT;
        long n;

        C0424b(ThreadFactory threadFactory, int i) {
            this.iKS = i;
            this.iKT = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iKT[i2] = new c(threadFactory);
            }
        }

        public c ceh() {
            int i = this.iKS;
            if (i == 0) {
                return b.iKL;
            }
            c[] cVarArr = this.iKT;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iKT) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ahS = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iKx.get().ceh());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0424b c0424b = new C0424b(this.ahS, iKK);
        if (!this.iKx.compareAndSet(iKM, c0424b)) {
            c0424b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0424b c0424b;
        do {
            c0424b = this.iKx.get();
            if (c0424b == iKM) {
                return;
            }
        } while (!this.iKx.compareAndSet(c0424b, iKM));
        c0424b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iKx.get().ceh().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iKN = new rx.internal.util.j();
        private final rx.subscriptions.b iKO = new rx.subscriptions.b();
        private final rx.internal.util.j iKP = new rx.internal.util.j(this.iKN, this.iKO);
        private final c iKQ;

        a(c cVar) {
            this.iKQ = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iKP.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iKP.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cft() : this.iKQ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iKN);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cft() : this.iKQ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iKO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
