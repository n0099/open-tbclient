package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iPb;
    static final c iPc;
    static final C0423b iPd;
    final ThreadFactory aib;
    final AtomicReference<C0423b> iOO = new AtomicReference<>(iPd);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iPb = intValue;
        iPc = new c(RxThreadFactory.NONE);
        iPc.unsubscribe();
        iPd = new C0423b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0423b {
        final int iPj;
        final c[] iPk;
        long n;

        C0423b(ThreadFactory threadFactory, int i) {
            this.iPj = i;
            this.iPk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iPk[i2] = new c(threadFactory);
            }
        }

        public c cfG() {
            int i = this.iPj;
            if (i == 0) {
                return b.iPc;
            }
            c[] cVarArr = this.iPk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iPk) {
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
        return new a(this.iOO.get().cfG());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0423b c0423b = new C0423b(this.aib, iPb);
        if (!this.iOO.compareAndSet(iPd, c0423b)) {
            c0423b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0423b c0423b;
        do {
            c0423b = this.iOO.get();
            if (c0423b == iPd) {
                return;
            }
        } while (!this.iOO.compareAndSet(c0423b, iPd));
        c0423b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iOO.get().cfG().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iPe = new rx.internal.util.j();
        private final rx.subscriptions.b iPf = new rx.subscriptions.b();
        private final rx.internal.util.j iPg = new rx.internal.util.j(this.iPe, this.iPf);
        private final c iPh;

        a(c cVar) {
            this.iPh = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iPg.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iPg.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cgS() : this.iPh.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iPe);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cgS() : this.iPh.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iPf);
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
