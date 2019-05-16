package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int krr;
    static final c krs;
    static final C0511b krt;
    final ThreadFactory agV;
    final AtomicReference<C0511b> krd = new AtomicReference<>(krt);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        krr = intValue;
        krs = new c(RxThreadFactory.NONE);
        krs.unsubscribe();
        krt = new C0511b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0511b {
        final c[] krA;
        final int krz;
        long n;

        C0511b(ThreadFactory threadFactory, int i) {
            this.krz = i;
            this.krA = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.krA[i2] = new c(threadFactory);
            }
        }

        public c cLR() {
            int i = this.krz;
            if (i == 0) {
                return b.krs;
            }
            c[] cVarArr = this.krA;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.krA) {
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
        return new a(this.krd.get().cLR());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0511b c0511b = new C0511b(this.agV, krr);
        if (!this.krd.compareAndSet(krt, c0511b)) {
            c0511b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0511b c0511b;
        do {
            c0511b = this.krd.get();
            if (c0511b == krt) {
                return;
            }
        } while (!this.krd.compareAndSet(c0511b, krt));
        c0511b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.krd.get().cLR().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kru = new rx.internal.util.i();
        private final rx.subscriptions.b krv = new rx.subscriptions.b();
        private final rx.internal.util.i krw = new rx.internal.util.i(this.kru, this.krv);
        private final c krx;

        a(c cVar) {
            this.krx = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.krw.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krw.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cNb() : this.krx.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kru);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cNb() : this.krx.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.krv);
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
