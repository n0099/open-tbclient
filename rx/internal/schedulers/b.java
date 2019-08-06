package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int kAa;
    static final c kAb;
    static final C0517b kAc;
    final ThreadFactory ahu;
    final AtomicReference<C0517b> kzM = new AtomicReference<>(kAc);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        kAa = intValue;
        kAb = new c(RxThreadFactory.NONE);
        kAb.unsubscribe();
        kAc = new C0517b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0517b {
        final int kAi;
        final c[] kAj;
        long n;

        C0517b(ThreadFactory threadFactory, int i) {
            this.kAi = i;
            this.kAj = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kAj[i2] = new c(threadFactory);
            }
        }

        public c cQc() {
            int i = this.kAi;
            if (i == 0) {
                return b.kAb;
            }
            c[] cVarArr = this.kAj;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kAj) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ahu = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kzM.get().cQc());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0517b c0517b = new C0517b(this.ahu, kAa);
        if (!this.kzM.compareAndSet(kAc, c0517b)) {
            c0517b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0517b c0517b;
        do {
            c0517b = this.kzM.get();
            if (c0517b == kAc) {
                return;
            }
        } while (!this.kzM.compareAndSet(c0517b, kAc));
        c0517b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kzM.get().cQc().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kAd = new rx.internal.util.i();
        private final rx.subscriptions.b kAe = new rx.subscriptions.b();
        private final rx.internal.util.i kAf = new rx.internal.util.i(this.kAd, this.kAe);
        private final c kAg;

        a(c cVar) {
            this.kAg = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kAf.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kAf.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cRo() : this.kAg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kAd);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cRo() : this.kAg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.kAe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
