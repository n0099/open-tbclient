package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final c nRG;
    static final C0799b nRH;
    static final int nzf;
    final ThreadFactory aRX;
    final AtomicReference<C0799b> nzh = new AtomicReference<>(nRH);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nzf = intValue;
        nRG = new c(RxThreadFactory.NONE);
        nRG.unsubscribe();
        nRH = new C0799b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0799b {
        long n;
        final c[] nRN;
        final int nzm;

        C0799b(ThreadFactory threadFactory, int i) {
            this.nzm = i;
            this.nRN = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nRN[i2] = new c(threadFactory);
            }
        }

        public c dOz() {
            int i = this.nzm;
            if (i == 0) {
                return b.nRG;
            }
            c[] cVarArr = this.nRN;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nRN) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aRX = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nzh.get().dOz());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0799b c0799b = new C0799b(this.aRX, nzf);
        if (!this.nzh.compareAndSet(nRH, c0799b)) {
            c0799b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0799b c0799b;
        do {
            c0799b = this.nzh.get();
            if (c0799b == nRH) {
                return;
            }
        } while (!this.nzh.compareAndSet(c0799b, nRH));
        c0799b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nzh.get().dOz().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nRI = new rx.internal.util.i();
        private final rx.subscriptions.b nRJ = new rx.subscriptions.b();
        private final rx.internal.util.i nRK = new rx.internal.util.i(this.nRI, this.nRJ);
        private final c nRL;

        a(c cVar) {
            this.nRL = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nRK.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRK.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dPD() : this.nRL.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nRI);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dPD() : this.nRL.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nRJ);
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
