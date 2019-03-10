package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int jZR;
    static final c jZS;
    static final C0395b jZT;
    final ThreadFactory agF;
    final AtomicReference<C0395b> jZD = new AtomicReference<>(jZT);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        jZR = intValue;
        jZS = new c(RxThreadFactory.NONE);
        jZS.unsubscribe();
        jZT = new C0395b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0395b {
        final int jZZ;
        final c[] kaa;
        long n;

        C0395b(ThreadFactory threadFactory, int i) {
            this.jZZ = i;
            this.kaa = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kaa[i2] = new c(threadFactory);
            }
        }

        public c cEt() {
            int i = this.jZZ;
            if (i == 0) {
                return b.jZS;
            }
            c[] cVarArr = this.kaa;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kaa) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agF = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.jZD.get().cEt());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0395b c0395b = new C0395b(this.agF, jZR);
        if (!this.jZD.compareAndSet(jZT, c0395b)) {
            c0395b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0395b c0395b;
        do {
            c0395b = this.jZD.get();
            if (c0395b == jZT) {
                return;
            }
        } while (!this.jZD.compareAndSet(c0395b, jZT));
        c0395b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.jZD.get().cEt().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i jZU = new rx.internal.util.i();
        private final rx.subscriptions.b jZV = new rx.subscriptions.b();
        private final rx.internal.util.i jZW = new rx.internal.util.i(this.jZU, this.jZV);
        private final c jZX;

        a(c cVar) {
            this.jZX = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.jZW.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZW.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cFD() : this.jZX.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.jZU);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cFD() : this.jZX.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.jZV);
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
