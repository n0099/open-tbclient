package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes7.dex */
public final class b extends rx.g implements h {
    static final c oRG;
    static final C0997b oRH;
    static final int ozh;
    final ThreadFactory ozj;
    final AtomicReference<C0997b> ozk = new AtomicReference<>(oRH);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        ozh = intValue;
        oRG = new c(RxThreadFactory.NONE);
        oRG.unsubscribe();
        oRH = new C0997b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0997b {
        long n;
        final c[] oRN;
        final int ozp;

        C0997b(ThreadFactory threadFactory, int i) {
            this.ozp = i;
            this.oRN = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.oRN[i2] = new c(threadFactory);
            }
        }

        public c eow() {
            int i = this.ozp;
            if (i == 0) {
                return b.oRG;
            }
            c[] cVarArr = this.oRN;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.oRN) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.ozk.get().eow());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0997b c0997b = new C0997b(this.ozj, ozh);
        if (!this.ozk.compareAndSet(oRH, c0997b)) {
            c0997b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0997b c0997b;
        do {
            c0997b = this.ozk.get();
            if (c0997b == oRH) {
                return;
            }
        } while (!this.ozk.compareAndSet(c0997b, oRH));
        c0997b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.ozk.get().eow().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes7.dex */
    static final class a extends g.a {
        private final rx.internal.util.i oRI = new rx.internal.util.i();
        private final rx.subscriptions.b oRJ = new rx.subscriptions.b();
        private final rx.internal.util.i oRK = new rx.internal.util.i(this.oRI, this.oRJ);
        private final c oRL;

        a(c cVar) {
            this.oRL = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.oRK.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oRK.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.epA() : this.oRL.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.oRI);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.epA() : this.oRL.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.oRJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
