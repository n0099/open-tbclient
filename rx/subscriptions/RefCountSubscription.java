package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes12.dex */
public final class RefCountSubscription implements k {
    static final a pWf = new a(false, 0);
    private final k pWe;
    final AtomicReference<a> pWg = new AtomicReference<>(pWf);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int pWh;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.pWh = i;
        }

        a eGW() {
            return new a(this.isUnsubscribed, this.pWh + 1);
        }

        a eGX() {
            return new a(this.isUnsubscribed, this.pWh - 1);
        }

        a eGY() {
            return new a(true, this.pWh);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.pWe = kVar;
    }

    public k eGU() {
        a aVar;
        AtomicReference<a> atomicReference = this.pWg;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eHa();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eGW()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWg.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eGY;
        AtomicReference<a> atomicReference = this.pWg;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eGY = aVar.eGY();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eGY));
        a(eGY);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.pWh == 0) {
            this.pWe.unsubscribe();
        }
    }

    void eGV() {
        a aVar;
        a eGX;
        AtomicReference<a> atomicReference = this.pWg;
        do {
            aVar = atomicReference.get();
            eGX = aVar.eGX();
        } while (!atomicReference.compareAndSet(aVar, eGX));
        a(eGX);
    }

    /* loaded from: classes12.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.eGV();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
