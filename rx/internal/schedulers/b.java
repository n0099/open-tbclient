package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final c nId;
    static final C0906b nIe;
    static final int npA;
    final ThreadFactory bvS;
    final AtomicReference<C0906b> npC = new AtomicReference<>(nIe);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        npA = intValue;
        nId = new c(RxThreadFactory.NONE);
        nId.unsubscribe();
        nIe = new C0906b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0906b {
        long n;
        final c[] nIk;
        final int npH;

        C0906b(ThreadFactory threadFactory, int i) {
            this.npH = i;
            this.nIk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nIk[i2] = new c(threadFactory);
            }
        }

        public c dPQ() {
            int i = this.npH;
            if (i == 0) {
                return b.nId;
            }
            c[] cVarArr = this.nIk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nIk) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.npC.get().dPQ());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0906b c0906b = new C0906b(this.bvS, npA);
        if (!this.npC.compareAndSet(nIe, c0906b)) {
            c0906b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0906b c0906b;
        do {
            c0906b = this.npC.get();
            if (c0906b == nIe) {
                return;
            }
        } while (!this.npC.compareAndSet(c0906b, nIe));
        c0906b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.npC.get().dPQ().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nIf = new rx.internal.util.i();
        private final rx.subscriptions.b nIg = new rx.subscriptions.b();
        private final rx.internal.util.i nIh = new rx.internal.util.i(this.nIf, this.nIg);
        private final c nIi;

        a(c cVar) {
            this.nIi = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nIh.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nIh.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dQU() : this.nIi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nIf);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dQU() : this.nIi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nIg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
