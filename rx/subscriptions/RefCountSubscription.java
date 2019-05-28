package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kuO = new a(false, 0);
    private final k kuN;
    final AtomicReference<a> kuP = new AtomicReference<>(kuO);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kuQ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kuQ = i;
        }

        a cMZ() {
            return new a(this.isUnsubscribed, this.kuQ + 1);
        }

        a cNa() {
            return new a(this.isUnsubscribed, this.kuQ - 1);
        }

        a cNb() {
            return new a(true, this.kuQ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kuN = kVar;
    }

    public k cMX() {
        a aVar;
        AtomicReference<a> atomicReference = this.kuP;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cNd();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cMZ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuP.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cNb;
        AtomicReference<a> atomicReference = this.kuP;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cNb = aVar.cNb();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cNb));
        a(cNb);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kuQ == 0) {
            this.kuN.unsubscribe();
        }
    }

    void cMY() {
        a aVar;
        a cNa;
        AtomicReference<a> atomicReference = this.kuP;
        do {
            aVar = atomicReference.get();
            cNa = aVar.cNa();
        } while (!atomicReference.compareAndSet(aVar, cNa));
        a(cNa);
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
                this.parent.cMY();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
