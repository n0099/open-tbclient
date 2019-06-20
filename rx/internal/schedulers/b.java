package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int krv;
    static final c krw;
    static final C0511b krx;
    final ThreadFactory agV;
    final AtomicReference<C0511b> krh = new AtomicReference<>(krx);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        krv = intValue;
        krw = new c(RxThreadFactory.NONE);
        krw.unsubscribe();
        krx = new C0511b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0511b {
        final int krD;
        final c[] krE;
        long n;

        C0511b(ThreadFactory threadFactory, int i) {
            this.krD = i;
            this.krE = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.krE[i2] = new c(threadFactory);
            }
        }

        public c cLS() {
            int i = this.krD;
            if (i == 0) {
                return b.krw;
            }
            c[] cVarArr = this.krE;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.krE) {
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
        return new a(this.krh.get().cLS());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0511b c0511b = new C0511b(this.agV, krv);
        if (!this.krh.compareAndSet(krx, c0511b)) {
            c0511b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0511b c0511b;
        do {
            c0511b = this.krh.get();
            if (c0511b == krx) {
                return;
            }
        } while (!this.krh.compareAndSet(c0511b, krx));
        c0511b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.krh.get().cLS().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final c krB;
        private final rx.internal.util.i kry = new rx.internal.util.i();
        private final rx.subscriptions.b krz = new rx.subscriptions.b();
        private final rx.internal.util.i krA = new rx.internal.util.i(this.kry, this.krz);

        a(c cVar) {
            this.krB = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.krA.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krA.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cNc() : this.krB.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kry);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cNc() : this.krB.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.krz);
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
