package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class RefCountSubscription implements k {
    static final a pjQ = new a(false, 0);
    private final k pjP;
    final AtomicReference<a> pjR = new AtomicReference<>(pjQ);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int pjS;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.pjS = i;
        }

        a eth() {
            return new a(this.isUnsubscribed, this.pjS + 1);
        }

        a eti() {
            return new a(this.isUnsubscribed, this.pjS - 1);
        }

        a etj() {
            return new a(true, this.pjS);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.pjP = kVar;
    }

    public k etf() {
        a aVar;
        AtomicReference<a> atomicReference = this.pjR;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.etl();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eth()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pjR.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a etj;
        AtomicReference<a> atomicReference = this.pjR;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                etj = aVar.etj();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, etj));
        a(etj);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.pjS == 0) {
            this.pjP.unsubscribe();
        }
    }

    void etg() {
        a aVar;
        a eti;
        AtomicReference<a> atomicReference = this.pjR;
        do {
            aVar = atomicReference.get();
            eti = aVar.eti();
        } while (!atomicReference.compareAndSet(aVar, eti));
        a(eti);
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
                this.parent.etg();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
