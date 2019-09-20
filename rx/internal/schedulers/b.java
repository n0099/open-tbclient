package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int kCs;
    static final c kCt;
    static final C0523b kCu;
    final ThreadFactory ahQ;
    final AtomicReference<C0523b> kCe = new AtomicReference<>(kCu);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        kCs = intValue;
        kCt = new c(RxThreadFactory.NONE);
        kCt.unsubscribe();
        kCu = new C0523b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0523b {
        final int kCA;
        final c[] kCB;
        long n;

        C0523b(ThreadFactory threadFactory, int i) {
            this.kCA = i;
            this.kCB = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kCB[i2] = new c(threadFactory);
            }
        }

        public c cQO() {
            int i = this.kCA;
            if (i == 0) {
                return b.kCt;
            }
            c[] cVarArr = this.kCB;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kCB) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ahQ = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kCe.get().cQO());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0523b c0523b = new C0523b(this.ahQ, kCs);
        if (!this.kCe.compareAndSet(kCu, c0523b)) {
            c0523b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0523b c0523b;
        do {
            c0523b = this.kCe.get();
            if (c0523b == kCu) {
                return;
            }
        } while (!this.kCe.compareAndSet(c0523b, kCu));
        c0523b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kCe.get().cQO().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kCv = new rx.internal.util.i();
        private final rx.subscriptions.b kCw = new rx.subscriptions.b();
        private final rx.internal.util.i kCx = new rx.internal.util.i(this.kCv, this.kCw);
        private final c kCy;

        a(c cVar) {
            this.kCy = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kCx.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCx.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cSa() : this.kCy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kCv);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cSa() : this.kCy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.kCw);
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
