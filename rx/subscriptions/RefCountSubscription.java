package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kGv = new a(false, 0);
    private final k kGu;
    final AtomicReference<a> kGw = new AtomicReference<>(kGv);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kGx;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kGx = i;
        }

        a cQb() {
            return new a(this.isUnsubscribed, this.kGx + 1);
        }

        a cQc() {
            return new a(this.isUnsubscribed, this.kGx - 1);
        }

        a cQd() {
            return new a(true, this.kGx);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kGu = kVar;
    }

    public k cPZ() {
        a aVar;
        AtomicReference<a> atomicReference = this.kGw;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cQf();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cQb()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kGw.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cQd;
        AtomicReference<a> atomicReference = this.kGw;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cQd = aVar.cQd();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cQd));
        a(cQd);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kGx == 0) {
            this.kGu.unsubscribe();
        }
    }

    void cQa() {
        a aVar;
        a cQc;
        AtomicReference<a> atomicReference = this.kGw;
        do {
            aVar = atomicReference.get();
            cQc = aVar.cQc();
        } while (!atomicReference.compareAndSet(aVar, cQc));
        a(cQc);
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
                this.parent.cQa();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
