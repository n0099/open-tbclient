package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class RefCountSubscription implements k {
    static final a oKT = new a(false, 0);
    private final k oKS;
    final AtomicReference<a> oKU = new AtomicReference<>(oKT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int oKV;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.oKV = i;
        }

        a ely() {
            return new a(this.isUnsubscribed, this.oKV + 1);
        }

        a elz() {
            return new a(this.isUnsubscribed, this.oKV - 1);
        }

        a elA() {
            return new a(true, this.oKV);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.oKS = kVar;
    }

    public k elw() {
        a aVar;
        AtomicReference<a> atomicReference = this.oKU;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.elC();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.ely()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oKU.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a elA;
        AtomicReference<a> atomicReference = this.oKU;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                elA = aVar.elA();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, elA));
        a(elA);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.oKV == 0) {
            this.oKS.unsubscribe();
        }
    }

    void elx() {
        a aVar;
        a elz;
        AtomicReference<a> atomicReference = this.oKU;
        do {
            aVar = atomicReference.get();
            elz = aVar.elz();
        } while (!atomicReference.compareAndSet(aVar, elz));
        a(elz);
    }

    /* loaded from: classes5.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.elx();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
