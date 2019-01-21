package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iPc;
    static final c iPd;
    static final C0423b iPe;
    final ThreadFactory aib;
    final AtomicReference<C0423b> iOP = new AtomicReference<>(iPe);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iPc = intValue;
        iPd = new c(RxThreadFactory.NONE);
        iPd.unsubscribe();
        iPe = new C0423b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0423b {
        final int iPk;
        final c[] iPl;
        long n;

        C0423b(ThreadFactory threadFactory, int i) {
            this.iPk = i;
            this.iPl = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iPl[i2] = new c(threadFactory);
            }
        }

        public c cfG() {
            int i = this.iPk;
            if (i == 0) {
                return b.iPd;
            }
            c[] cVarArr = this.iPl;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iPl) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aib = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iOP.get().cfG());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0423b c0423b = new C0423b(this.aib, iPc);
        if (!this.iOP.compareAndSet(iPe, c0423b)) {
            c0423b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0423b c0423b;
        do {
            c0423b = this.iOP.get();
            if (c0423b == iPe) {
                return;
            }
        } while (!this.iOP.compareAndSet(c0423b, iPe));
        c0423b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iOP.get().cfG().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iPf = new rx.internal.util.j();
        private final rx.subscriptions.b iPg = new rx.subscriptions.b();
        private final rx.internal.util.j iPh = new rx.internal.util.j(this.iPf, this.iPg);
        private final c iPi;

        a(c cVar) {
            this.iPi = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iPh.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iPh.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cgS() : this.iPi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iPf);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cgS() : this.iPi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iPg);
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
