package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int nAS;
    static final c nTt;
    static final C0800b nTu;
    final ThreadFactory aSk;
    final AtomicReference<C0800b> nAU = new AtomicReference<>(nTu);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nAS = intValue;
        nTt = new c(RxThreadFactory.NONE);
        nTt.unsubscribe();
        nTu = new C0800b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0800b {
        long n;
        final int nAZ;
        final c[] nTA;

        C0800b(ThreadFactory threadFactory, int i) {
            this.nAZ = i;
            this.nTA = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nTA[i2] = new c(threadFactory);
            }
        }

        public c dOZ() {
            int i = this.nAZ;
            if (i == 0) {
                return b.nTt;
            }
            c[] cVarArr = this.nTA;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nTA) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aSk = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nAU.get().dOZ());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0800b c0800b = new C0800b(this.aSk, nAS);
        if (!this.nAU.compareAndSet(nTu, c0800b)) {
            c0800b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0800b c0800b;
        do {
            c0800b = this.nAU.get();
            if (c0800b == nTu) {
                return;
            }
        } while (!this.nAU.compareAndSet(c0800b, nTu));
        c0800b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nAU.get().dOZ().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nTv = new rx.internal.util.i();
        private final rx.subscriptions.b nTw = new rx.subscriptions.b();
        private final rx.internal.util.i nTx = new rx.internal.util.i(this.nTv, this.nTw);
        private final c nTy;

        a(c cVar) {
            this.nTy = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nTx.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nTx.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dQd() : this.nTy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nTv);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dQd() : this.nTy.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nTw);
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
