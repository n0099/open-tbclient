package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes12.dex */
public final class RefCountSubscription implements k {
    static final a pWh = new a(false, 0);
    private final k pWg;
    final AtomicReference<a> pWi = new AtomicReference<>(pWh);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int pWj;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.pWj = i;
        }

        a eGX() {
            return new a(this.isUnsubscribed, this.pWj + 1);
        }

        a eGY() {
            return new a(this.isUnsubscribed, this.pWj - 1);
        }

        a eGZ() {
            return new a(true, this.pWj);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.pWg = kVar;
    }

    public k eGV() {
        a aVar;
        AtomicReference<a> atomicReference = this.pWi;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eHb();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eGX()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWi.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eGZ;
        AtomicReference<a> atomicReference = this.pWi;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eGZ = aVar.eGZ();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eGZ));
        a(eGZ);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.pWj == 0) {
            this.pWg.unsubscribe();
        }
    }

    void eGW() {
        a aVar;
        a eGY;
        AtomicReference<a> atomicReference = this.pWi;
        do {
            aVar = atomicReference.get();
            eGY = aVar.eGY();
        } while (!atomicReference.compareAndSet(aVar, eGY));
        a(eGY);
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
                this.parent.eGW();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
