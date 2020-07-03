package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int nMx;
    static final c ofa;
    static final C0926b ofb;
    final ThreadFactory bAJ;
    final AtomicReference<C0926b> nMz = new AtomicReference<>(ofb);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nMx = intValue;
        ofa = new c(RxThreadFactory.NONE);
        ofa.unsubscribe();
        ofb = new C0926b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0926b {
        long n;
        final int nME;
        final c[] ofi;

        C0926b(ThreadFactory threadFactory, int i) {
            this.nME = i;
            this.ofi = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.ofi[i2] = new c(threadFactory);
            }
        }

        public c dUK() {
            int i = this.nME;
            if (i == 0) {
                return b.ofa;
            }
            c[] cVarArr = this.ofi;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.ofi) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nMz.get().dUK());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0926b c0926b = new C0926b(this.bAJ, nMx);
        if (!this.nMz.compareAndSet(ofb, c0926b)) {
            c0926b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0926b c0926b;
        do {
            c0926b = this.nMz.get();
            if (c0926b == ofb) {
                return;
            }
        } while (!this.nMz.compareAndSet(c0926b, ofb));
        c0926b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nMz.get().dUK().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i ofc = new rx.internal.util.i();
        private final rx.subscriptions.b ofd = new rx.subscriptions.b();
        private final rx.internal.util.i ofe = new rx.internal.util.i(this.ofc, this.ofd);
        private final c ofg;

        a(c cVar) {
            this.ofg = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.ofe.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.ofe.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dVO() : this.ofg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.ofc);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dVO() : this.ofg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.ofd);
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
