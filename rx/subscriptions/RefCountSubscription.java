package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a ohW = new a(false, 0);
    private final k ohV;
    final AtomicReference<a> ohX = new AtomicReference<>(ohW);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int ohY;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.ohY = i;
        }

        a dVO() {
            return new a(this.isUnsubscribed, this.ohY + 1);
        }

        a dVP() {
            return new a(this.isUnsubscribed, this.ohY - 1);
        }

        a dVQ() {
            return new a(true, this.ohY);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.ohV = kVar;
    }

    public k dVM() {
        a aVar;
        AtomicReference<a> atomicReference = this.ohX;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dVS();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dVO()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ohX.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dVQ;
        AtomicReference<a> atomicReference = this.ohX;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dVQ = aVar.dVQ();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dVQ));
        a(dVQ);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.ohY == 0) {
            this.ohV.unsubscribe();
        }
    }

    void dVN() {
        a aVar;
        a dVP;
        AtomicReference<a> atomicReference = this.ohX;
        do {
            aVar = atomicReference.get();
            dVP = aVar.dVP();
        } while (!atomicReference.compareAndSet(aVar, dVP));
        a(dVP);
    }

    /* loaded from: classes6.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.dVN();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
