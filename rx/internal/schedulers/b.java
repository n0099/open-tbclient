package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int nVi;
    static final c onM;
    static final C0942b onN;
    final ThreadFactory nVk;
    final AtomicReference<C0942b> nVl = new AtomicReference<>(onN);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nVi = intValue;
        onM = new c(RxThreadFactory.NONE);
        onM.unsubscribe();
        onN = new C0942b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0942b {
        long n;
        final int nVq;
        final c[] onT;

        C0942b(ThreadFactory threadFactory, int i) {
            this.nVq = i;
            this.onT = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.onT[i2] = new c(threadFactory);
            }
        }

        public c dYk() {
            int i = this.nVq;
            if (i == 0) {
                return b.onM;
            }
            c[] cVarArr = this.onT;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.onT) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.nVk = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nVl.get().dYk());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0942b c0942b = new C0942b(this.nVk, nVi);
        if (!this.nVl.compareAndSet(onN, c0942b)) {
            c0942b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0942b c0942b;
        do {
            c0942b = this.nVl.get();
            if (c0942b == onN) {
                return;
            }
        } while (!this.nVl.compareAndSet(c0942b, onN));
        c0942b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nVl.get().dYk().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i onO = new rx.internal.util.i();
        private final rx.subscriptions.b onP = new rx.subscriptions.b();
        private final rx.internal.util.i onQ = new rx.internal.util.i(this.onO, this.onP);
        private final c onR;

        a(c cVar) {
            this.onR = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.onQ.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.onQ.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dZo() : this.onR.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.onO);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dZo() : this.onR.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.onP);
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
