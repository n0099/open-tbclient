package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes12.dex */
public final class b extends rx.g implements h {
    static final int pHE;
    static final c pTo;
    static final C1074b pTp;
    final ThreadFactory pHG;
    final AtomicReference<C1074b> pHH = new AtomicReference<>(pTp);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        pHE = intValue;
        pTo = new c(RxThreadFactory.NONE);
        pTo.unsubscribe();
        pTp = new C1074b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1074b {
        long n;
        final int pHM;
        final c[] pTv;

        C1074b(ThreadFactory threadFactory, int i) {
            this.pHM = i;
            this.pTv = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pTv[i2] = new c(threadFactory);
            }
        }

        public c eFU() {
            int i = this.pHM;
            if (i == 0) {
                return b.pTo;
            }
            c[] cVarArr = this.pTv;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pTv) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.pHH.get().eFU());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1074b c1074b = new C1074b(this.pHG, pHE);
        if (!this.pHH.compareAndSet(pTp, c1074b)) {
            c1074b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1074b c1074b;
        do {
            c1074b = this.pHH.get();
            if (c1074b == pTp) {
                return;
            }
        } while (!this.pHH.compareAndSet(c1074b, pTp));
        c1074b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.pHH.get().eFU().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes12.dex */
    static final class a extends g.a {
        private final rx.internal.util.i pTq = new rx.internal.util.i();
        private final rx.subscriptions.b pTr = new rx.subscriptions.b();
        private final rx.internal.util.i pTs = new rx.internal.util.i(this.pTq, this.pTr);
        private final c pTt;

        a(c cVar) {
            this.pTt = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pTs.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pTs.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eHa() : this.pTt.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.pTq);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eHa() : this.pTt.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.pTr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
