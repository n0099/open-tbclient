package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final c nRt;
    static final C0799b nRu;
    static final int nyS;
    final ThreadFactory aRV;
    final AtomicReference<C0799b> nyU = new AtomicReference<>(nRu);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nyS = intValue;
        nRt = new c(RxThreadFactory.NONE);
        nRt.unsubscribe();
        nRu = new C0799b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0799b {
        long n;
        final c[] nRA;
        final int nyZ;

        C0799b(ThreadFactory threadFactory, int i) {
            this.nyZ = i;
            this.nRA = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nRA[i2] = new c(threadFactory);
            }
        }

        public c dOw() {
            int i = this.nyZ;
            if (i == 0) {
                return b.nRt;
            }
            c[] cVarArr = this.nRA;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nRA) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nyU.get().dOw());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0799b c0799b = new C0799b(this.aRV, nyS);
        if (!this.nyU.compareAndSet(nRu, c0799b)) {
            c0799b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0799b c0799b;
        do {
            c0799b = this.nyU.get();
            if (c0799b == nRu) {
                return;
            }
        } while (!this.nyU.compareAndSet(c0799b, nRu));
        c0799b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nyU.get().dOw().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nRv = new rx.internal.util.i();
        private final rx.subscriptions.b nRw = new rx.subscriptions.b();
        private final rx.internal.util.i nRx = new rx.internal.util.i(this.nRv, this.nRw);
        private final c nRy;

        a(c cVar) {
            this.nRy = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nRx.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRx.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dPA() : this.nRy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nRv);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dPA() : this.nRy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nRw);
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
