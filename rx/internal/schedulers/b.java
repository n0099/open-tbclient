package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int krs;
    static final c krt;
    static final C0511b kru;
    final ThreadFactory agV;
    final AtomicReference<C0511b> kre = new AtomicReference<>(kru);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        krs = intValue;
        krt = new c(RxThreadFactory.NONE);
        krt.unsubscribe();
        kru = new C0511b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0511b {
        final int krA;
        final c[] krB;
        long n;

        C0511b(ThreadFactory threadFactory, int i) {
            this.krA = i;
            this.krB = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.krB[i2] = new c(threadFactory);
            }
        }

        public c cLT() {
            int i = this.krA;
            if (i == 0) {
                return b.krt;
            }
            c[] cVarArr = this.krB;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.krB) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agV = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kre.get().cLT());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0511b c0511b = new C0511b(this.agV, krs);
        if (!this.kre.compareAndSet(kru, c0511b)) {
            c0511b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0511b c0511b;
        do {
            c0511b = this.kre.get();
            if (c0511b == kru) {
                return;
            }
        } while (!this.kre.compareAndSet(c0511b, kru));
        c0511b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kre.get().cLT().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i krv = new rx.internal.util.i();
        private final rx.subscriptions.b krw = new rx.subscriptions.b();
        private final rx.internal.util.i krx = new rx.internal.util.i(this.krv, this.krw);
        private final c kry;

        a(c cVar) {
            this.kry = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.krx.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krx.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cNd() : this.kry.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.krv);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cNd() : this.kry.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.krw);
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
