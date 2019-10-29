package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int kDa;
    static final c kDb;
    static final C0624b kDc;
    final ThreadFactory aBo;
    final AtomicReference<C0624b> kCM = new AtomicReference<>(kDc);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        kDa = intValue;
        kDb = new c(RxThreadFactory.NONE);
        kDb.unsubscribe();
        kDc = new C0624b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0624b {
        final int kDi;
        final c[] kDj;
        long n;

        C0624b(ThreadFactory threadFactory, int i) {
            this.kDi = i;
            this.kDj = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kDj[i2] = new c(threadFactory);
            }
        }

        public c cOT() {
            int i = this.kDi;
            if (i == 0) {
                return b.kDb;
            }
            c[] cVarArr = this.kDj;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kDj) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aBo = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kCM.get().cOT());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0624b c0624b = new C0624b(this.aBo, kDa);
        if (!this.kCM.compareAndSet(kDc, c0624b)) {
            c0624b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0624b c0624b;
        do {
            c0624b = this.kCM.get();
            if (c0624b == kDc) {
                return;
            }
        } while (!this.kCM.compareAndSet(c0624b, kDc));
        c0624b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kCM.get().cOT().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kDd = new rx.internal.util.i();
        private final rx.subscriptions.b kDe = new rx.subscriptions.b();
        private final rx.internal.util.i kDf = new rx.internal.util.i(this.kDd, this.kDe);
        private final c kDg;

        a(c cVar) {
            this.kDg = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kDf.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kDf.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cQf() : this.kDg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kDd);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cQf() : this.kDg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.kDe);
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
