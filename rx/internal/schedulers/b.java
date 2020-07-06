package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int nMA;
    static final c ofd;
    static final C0927b ofe;
    final ThreadFactory bAJ;
    final AtomicReference<C0927b> nMC = new AtomicReference<>(ofe);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nMA = intValue;
        ofd = new c(RxThreadFactory.NONE);
        ofd.unsubscribe();
        ofe = new C0927b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0927b {
        long n;
        final int nMH;
        final c[] ofl;

        C0927b(ThreadFactory threadFactory, int i) {
            this.nMH = i;
            this.ofl = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.ofl[i2] = new c(threadFactory);
            }
        }

        public c dUO() {
            int i = this.nMH;
            if (i == 0) {
                return b.ofd;
            }
            c[] cVarArr = this.ofl;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.ofl) {
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
        return new a(this.nMC.get().dUO());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0927b c0927b = new C0927b(this.bAJ, nMA);
        if (!this.nMC.compareAndSet(ofe, c0927b)) {
            c0927b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0927b c0927b;
        do {
            c0927b = this.nMC.get();
            if (c0927b == ofe) {
                return;
            }
        } while (!this.nMC.compareAndSet(c0927b, ofe));
        c0927b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nMC.get().dUO().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i ofg = new rx.internal.util.i();
        private final rx.subscriptions.b ofh = new rx.subscriptions.b();
        private final rx.internal.util.i ofi = new rx.internal.util.i(this.ofg, this.ofh);
        private final c ofj;

        a(c cVar) {
            this.ofj = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.ofi.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.ofi.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dVS() : this.ofj.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.ofg);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dVS() : this.ofj.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.ofh);
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
