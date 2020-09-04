package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes5.dex */
public final class b extends rx.g implements h {
    static final c oIb;
    static final C1000b oIc;
    static final int opz;
    final ThreadFactory opB;
    final AtomicReference<C1000b> opC = new AtomicReference<>(oIc);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        opz = intValue;
        oIb = new c(RxThreadFactory.NONE);
        oIb.unsubscribe();
        oIc = new C1000b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1000b {
        long n;
        final c[] oIi;
        final int opH;

        C1000b(ThreadFactory threadFactory, int i) {
            this.opH = i;
            this.oIi = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.oIi[i2] = new c(threadFactory);
            }
        }

        public c eky() {
            int i = this.opH;
            if (i == 0) {
                return b.oIb;
            }
            c[] cVarArr = this.oIi;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.oIi) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.opB = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.opC.get().eky());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1000b c1000b = new C1000b(this.opB, opz);
        if (!this.opC.compareAndSet(oIc, c1000b)) {
            c1000b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1000b c1000b;
        do {
            c1000b = this.opC.get();
            if (c1000b == oIc) {
                return;
            }
        } while (!this.opC.compareAndSet(c1000b, oIc));
        c1000b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.opC.get().eky().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes5.dex */
    static final class a extends g.a {
        private final rx.internal.util.i oId = new rx.internal.util.i();
        private final rx.subscriptions.b oIe = new rx.subscriptions.b();
        private final rx.internal.util.i oIf = new rx.internal.util.i(this.oId, this.oIe);
        private final c oIg;

        a(c cVar) {
            this.oIg = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.oIf.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oIf.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.elC() : this.oIg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.oId);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.elC() : this.oIg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.oIe);
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
