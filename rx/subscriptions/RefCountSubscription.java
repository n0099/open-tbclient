package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes15.dex */
public final class RefCountSubscription implements k {
    static final a qzp = new a(false, 0);
    private final k qzo;
    final AtomicReference<a> qzq = new AtomicReference<>(qzp);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qzr;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qzr = i;
        }

        a ePJ() {
            return new a(this.isUnsubscribed, this.qzr + 1);
        }

        a ePK() {
            return new a(this.isUnsubscribed, this.qzr - 1);
        }

        a ePL() {
            return new a(true, this.qzr);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qzo = kVar;
    }

    public k ePH() {
        a aVar;
        AtomicReference<a> atomicReference = this.qzq;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.ePN();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.ePJ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qzq.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a ePL;
        AtomicReference<a> atomicReference = this.qzq;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                ePL = aVar.ePL();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, ePL));
        a(ePL);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qzr == 0) {
            this.qzo.unsubscribe();
        }
    }

    void ePI() {
        a aVar;
        a ePK;
        AtomicReference<a> atomicReference = this.qzq;
        do {
            aVar = atomicReference.get();
            ePK = aVar.ePK();
        } while (!atomicReference.compareAndSet(aVar, ePK));
        a(ePK);
    }

    /* loaded from: classes15.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.ePI();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
