package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kFO = new a(false, 0);
    private final k kFN;
    final AtomicReference<a> kFP = new AtomicReference<>(kFO);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kFQ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kFQ = i;
        }

        a cRW() {
            return new a(this.isUnsubscribed, this.kFQ + 1);
        }

        a cRX() {
            return new a(this.isUnsubscribed, this.kFQ - 1);
        }

        a cRY() {
            return new a(true, this.kFQ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kFN = kVar;
    }

    public k cRU() {
        a aVar;
        AtomicReference<a> atomicReference = this.kFP;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cSa();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cRW()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kFP.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cRY;
        AtomicReference<a> atomicReference = this.kFP;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cRY = aVar.cRY();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cRY));
        a(cRY);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kFQ == 0) {
            this.kFN.unsubscribe();
        }
    }

    void cRV() {
        a aVar;
        a cRX;
        AtomicReference<a> atomicReference = this.kFP;
        do {
            aVar = atomicReference.get();
            cRX = aVar.cRX();
        } while (!atomicReference.compareAndSet(aVar, cRX));
        a(cRX);
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
                this.parent.cRV();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
