package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes16.dex */
public final class b extends rx.g implements h {
    static final int pFT;
    static final c pYp;
    static final C1087b pYq;
    final ThreadFactory pFV;
    final AtomicReference<C1087b> pFW = new AtomicReference<>(pYq);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        pFT = intValue;
        pYp = new c(RxThreadFactory.NONE);
        pYp.unsubscribe();
        pYq = new C1087b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C1087b {
        long n;
        final int pGb;
        final c[] pYw;

        C1087b(ThreadFactory threadFactory, int i) {
            this.pGb = i;
            this.pYw = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.pYw[i2] = new c(threadFactory);
            }
        }

        public c eCf() {
            int i = this.pGb;
            if (i == 0) {
                return b.pYp;
            }
            c[] cVarArr = this.pYw;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.pYw) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.pFV = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.pFW.get().eCf());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1087b c1087b = new C1087b(this.pFV, pFT);
        if (!this.pFW.compareAndSet(pYq, c1087b)) {
            c1087b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1087b c1087b;
        do {
            c1087b = this.pFW.get();
            if (c1087b == pYq) {
                return;
            }
        } while (!this.pFW.compareAndSet(c1087b, pYq));
        c1087b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.pFW.get().eCf().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes16.dex */
    static final class a extends g.a {
        private final rx.internal.util.i pYr = new rx.internal.util.i();
        private final rx.subscriptions.b pYs = new rx.subscriptions.b();
        private final rx.internal.util.i pYt = new rx.internal.util.i(this.pYr, this.pYs);
        private final c pYu;

        a(c cVar) {
            this.pYu = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pYt.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pYt.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eDj() : this.pYu.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.pYr);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eDj() : this.pYu.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.pYs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
