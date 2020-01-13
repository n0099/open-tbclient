package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes5.dex */
public final class b extends rx.g implements h {
    static final C0791b nQA;
    static final c nQz;
    static final int nyl;
    final ThreadFactory aNw;
    final AtomicReference<C0791b> nyn = new AtomicReference<>(nQA);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nyl = intValue;
        nQz = new c(RxThreadFactory.NONE);
        nQz.unsubscribe();
        nQA = new C0791b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0791b {
        long n;
        final c[] nQG;
        final int nys;

        C0791b(ThreadFactory threadFactory, int i) {
            this.nys = i;
            this.nQG = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nQG[i2] = new c(threadFactory);
            }
        }

        public c dNh() {
            int i = this.nys;
            if (i == 0) {
                return b.nQz;
            }
            c[] cVarArr = this.nQG;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nQG) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nyn.get().dNh());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0791b c0791b = new C0791b(this.aNw, nyl);
        if (!this.nyn.compareAndSet(nQA, c0791b)) {
            c0791b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0791b c0791b;
        do {
            c0791b = this.nyn.get();
            if (c0791b == nQA) {
                return;
            }
        } while (!this.nyn.compareAndSet(c0791b, nQA));
        c0791b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nyn.get().dNh().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes5.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nQB = new rx.internal.util.i();
        private final rx.subscriptions.b nQC = new rx.subscriptions.b();
        private final rx.internal.util.i nQD = new rx.internal.util.i(this.nQB, this.nQC);
        private final c nQE;

        a(c cVar) {
            this.nQE = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nQD.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nQD.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dOl() : this.nQE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nQB);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dOl() : this.nQE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nQC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
