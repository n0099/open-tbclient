package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int nVk;
    static final c onO;
    static final C0942b onP;
    final ThreadFactory nVm;
    final AtomicReference<C0942b> nVn = new AtomicReference<>(onP);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nVk = intValue;
        onO = new c(RxThreadFactory.NONE);
        onO.unsubscribe();
        onP = new C0942b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0942b {
        long n;
        final int nVs;
        final c[] onV;

        C0942b(ThreadFactory threadFactory, int i) {
            this.nVs = i;
            this.onV = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.onV[i2] = new c(threadFactory);
            }
        }

        public c dYl() {
            int i = this.nVs;
            if (i == 0) {
                return b.onO;
            }
            c[] cVarArr = this.onV;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.onV) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.nVm = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nVn.get().dYl());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0942b c0942b = new C0942b(this.nVm, nVk);
        if (!this.nVn.compareAndSet(onP, c0942b)) {
            c0942b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0942b c0942b;
        do {
            c0942b = this.nVn.get();
            if (c0942b == onP) {
                return;
            }
        } while (!this.nVn.compareAndSet(c0942b, onP));
        c0942b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nVn.get().dYl().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i onQ = new rx.internal.util.i();
        private final rx.subscriptions.b onR = new rx.subscriptions.b();
        private final rx.internal.util.i onS = new rx.internal.util.i(this.onQ, this.onR);
        private final c onT;

        a(c cVar) {
            this.onT = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.onS.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.onS.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dZp() : this.onT.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.onQ);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dZp() : this.onT.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.onR);
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
