package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes12.dex */
public final class b extends rx.g implements h {
    static final int pHG;
    static final c pTq;
    static final C1074b pTr;
    final ThreadFactory pHI;
    final AtomicReference<C1074b> pHJ = new AtomicReference<>(pTr);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        pHG = intValue;
        pTq = new c(RxThreadFactory.NONE);
        pTq.unsubscribe();
        pTr = new C1074b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1074b {
        long n;
        final int pHO;
        final c[] pTx;

        C1074b(ThreadFactory threadFactory, int i) {
            this.pHO = i;
            this.pTx = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pTx[i2] = new c(threadFactory);
            }
        }

        public c eFV() {
            int i = this.pHO;
            if (i == 0) {
                return b.pTq;
            }
            c[] cVarArr = this.pTx;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pTx) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.pHJ.get().eFV());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1074b c1074b = new C1074b(this.pHI, pHG);
        if (!this.pHJ.compareAndSet(pTr, c1074b)) {
            c1074b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1074b c1074b;
        do {
            c1074b = this.pHJ.get();
            if (c1074b == pTr) {
                return;
            }
        } while (!this.pHJ.compareAndSet(c1074b, pTr));
        c1074b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.pHJ.get().eFV().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes12.dex */
    static final class a extends g.a {
        private final rx.internal.util.i pTs = new rx.internal.util.i();
        private final rx.subscriptions.b pTt = new rx.subscriptions.b();
        private final rx.internal.util.i pTu = new rx.internal.util.i(this.pTs, this.pTt);
        private final c pTv;

        a(c cVar) {
            this.pTv = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pTu.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pTu.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eHb() : this.pTv.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.pTs);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eHb() : this.pTv.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.pTt);
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
