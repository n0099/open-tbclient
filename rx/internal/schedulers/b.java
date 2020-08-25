package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes5.dex */
public final class b extends rx.g implements h {
    static final c oHJ;
    static final C1000b oHK;
    static final int opg;
    final ThreadFactory opi;
    final AtomicReference<C1000b> opj = new AtomicReference<>(oHK);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        opg = intValue;
        oHJ = new c(RxThreadFactory.NONE);
        oHJ.unsubscribe();
        oHK = new C1000b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1000b {
        long n;
        final c[] oHQ;
        final int opo;

        C1000b(ThreadFactory threadFactory, int i) {
            this.opo = i;
            this.oHQ = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.oHQ[i2] = new c(threadFactory);
            }
        }

        public c ekp() {
            int i = this.opo;
            if (i == 0) {
                return b.oHJ;
            }
            c[] cVarArr = this.oHQ;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.oHQ) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.opi = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.opj.get().ekp());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1000b c1000b = new C1000b(this.opi, opg);
        if (!this.opj.compareAndSet(oHK, c1000b)) {
            c1000b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1000b c1000b;
        do {
            c1000b = this.opj.get();
            if (c1000b == oHK) {
                return;
            }
        } while (!this.opj.compareAndSet(c1000b, oHK));
        c1000b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.opj.get().ekp().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes5.dex */
    static final class a extends g.a {
        private final rx.internal.util.i oHL = new rx.internal.util.i();
        private final rx.subscriptions.b oHM = new rx.subscriptions.b();
        private final rx.internal.util.i oHN = new rx.internal.util.i(this.oHL, this.oHM);
        private final c oHO;

        a(c cVar) {
            this.oHO = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.oHN.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oHN.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.elt() : this.oHO.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.oHL);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.elt() : this.oHO.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.oHM);
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
