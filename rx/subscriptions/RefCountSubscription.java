package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes14.dex */
public final class RefCountSubscription implements k {
    static final a quO = new a(false, 0);
    private final k quN;
    final AtomicReference<a> quP = new AtomicReference<>(quO);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int quQ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.quQ = i;
        }

        a eLT() {
            return new a(this.isUnsubscribed, this.quQ + 1);
        }

        a eLU() {
            return new a(this.isUnsubscribed, this.quQ - 1);
        }

        a eLV() {
            return new a(true, this.quQ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.quN = kVar;
    }

    public k eLR() {
        a aVar;
        AtomicReference<a> atomicReference = this.quP;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eLX();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eLT()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.quP.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eLV;
        AtomicReference<a> atomicReference = this.quP;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eLV = aVar.eLV();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eLV));
        a(eLV);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.quQ == 0) {
            this.quN.unsubscribe();
        }
    }

    void eLS() {
        a aVar;
        a eLU;
        AtomicReference<a> atomicReference = this.quP;
        do {
            aVar = atomicReference.get();
            eLU = aVar.eLU();
        } while (!atomicReference.compareAndSet(aVar, eLU));
        a(eLU);
    }

    /* loaded from: classes14.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.eLS();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
