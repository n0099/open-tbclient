package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes5.dex */
public final class b extends rx.g implements h {
    static final c nQE;
    static final C0791b nQF;
    static final int nyq;
    final ThreadFactory aNw;
    final AtomicReference<C0791b> nys = new AtomicReference<>(nQF);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nyq = intValue;
        nQE = new c(RxThreadFactory.NONE);
        nQE.unsubscribe();
        nQF = new C0791b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0791b {
        long n;
        final c[] nQL;
        final int nyx;

        C0791b(ThreadFactory threadFactory, int i) {
            this.nyx = i;
            this.nQL = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nQL[i2] = new c(threadFactory);
            }
        }

        public c dNj() {
            int i = this.nyx;
            if (i == 0) {
                return b.nQE;
            }
            c[] cVarArr = this.nQL;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nQL) {
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
        return new a(this.nys.get().dNj());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0791b c0791b = new C0791b(this.aNw, nyq);
        if (!this.nys.compareAndSet(nQF, c0791b)) {
            c0791b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0791b c0791b;
        do {
            c0791b = this.nys.get();
            if (c0791b == nQF) {
                return;
            }
        } while (!this.nys.compareAndSet(c0791b, nQF));
        c0791b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nys.get().dNj().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes5.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nQG = new rx.internal.util.i();
        private final rx.subscriptions.b nQH = new rx.subscriptions.b();
        private final rx.internal.util.i nQI = new rx.internal.util.i(this.nQG, this.nQH);
        private final c nQJ;

        a(c cVar) {
            this.nQJ = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nQI.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nQI.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dOn() : this.nQJ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nQG);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dOn() : this.nQJ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nQH);
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
