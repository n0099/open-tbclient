package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iOC = new a(false, 0);
    private final k iOB;
    final AtomicReference<a> iOD = new AtomicReference<>(iOC);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iOE;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iOE = i;
        }

        a cfq() {
            return new a(this.isUnsubscribed, this.iOE + 1);
        }

        a cfr() {
            return new a(this.isUnsubscribed, this.iOE - 1);
        }

        a cfs() {
            return new a(true, this.iOE);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iOB = kVar;
    }

    public k cfo() {
        a aVar;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cfu();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cfq()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iOD.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cfs;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cfs = aVar.cfs();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cfs));
        a(cfs);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iOE == 0) {
            this.iOB.unsubscribe();
        }
    }

    void cfp() {
        a aVar;
        a cfr;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            cfr = aVar.cfr();
        } while (!atomicReference.compareAndSet(aVar, cfr));
        a(cfr);
    }

    /* loaded from: classes2.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.cfp();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
