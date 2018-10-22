package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iBT;
    static final c iBU;
    static final C0382b iBV;
    final ThreadFactory iBF;
    final AtomicReference<C0382b> iBG = new AtomicReference<>(iBV);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iBT = intValue;
        iBU = new c(RxThreadFactory.NONE);
        iBU.unsubscribe();
        iBV = new C0382b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0382b {
        final int iCb;
        final c[] iCc;
        long n;

        C0382b(ThreadFactory threadFactory, int i) {
            this.iCb = i;
            this.iCc = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iCc[i2] = new c(threadFactory);
            }
        }

        public c ccI() {
            int i = this.iCb;
            if (i == 0) {
                return b.iBU;
            }
            c[] cVarArr = this.iCc;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iCc) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.iBF = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iBG.get().ccI());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0382b c0382b = new C0382b(this.iBF, iBT);
        if (!this.iBG.compareAndSet(iBV, c0382b)) {
            c0382b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0382b c0382b;
        do {
            c0382b = this.iBG.get();
            if (c0382b == iBV) {
                return;
            }
        } while (!this.iBG.compareAndSet(c0382b, iBV));
        c0382b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iBG.get().ccI().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iBW = new rx.internal.util.j();
        private final rx.subscriptions.b iBX = new rx.subscriptions.b();
        private final rx.internal.util.j iBY = new rx.internal.util.j(this.iBW, this.iBX);
        private final c iBZ;

        a(c cVar) {
            this.iBZ = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iBY.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iBY.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cdU() : this.iBZ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iBW);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cdU() : this.iBZ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iBX);
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
