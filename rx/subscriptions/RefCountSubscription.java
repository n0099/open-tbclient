package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class RefCountSubscription implements k {
    static final a qkB = new a(false, 0);
    private final k qkA;
    final AtomicReference<a> qkC = new AtomicReference<>(qkB);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qkD;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qkD = i;
        }

        a eGU() {
            return new a(this.isUnsubscribed, this.qkD + 1);
        }

        a eGV() {
            return new a(this.isUnsubscribed, this.qkD - 1);
        }

        a eGW() {
            return new a(true, this.qkD);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qkA = kVar;
    }

    public k eGS() {
        a aVar;
        AtomicReference<a> atomicReference = this.qkC;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eGY();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eGU()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qkC.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eGW;
        AtomicReference<a> atomicReference = this.qkC;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eGW = aVar.eGW();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eGW));
        a(eGW);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qkD == 0) {
            this.qkA.unsubscribe();
        }
    }

    void eGT() {
        a aVar;
        a eGV;
        AtomicReference<a> atomicReference = this.qkC;
        do {
            aVar = atomicReference.get();
            eGV = aVar.eGV();
        } while (!atomicReference.compareAndSet(aVar, eGV));
        a(eGV);
    }

    /* loaded from: classes16.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.eGT();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
