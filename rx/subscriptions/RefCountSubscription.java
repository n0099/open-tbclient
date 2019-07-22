package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kCq = new a(false, 0);
    private final k kCp;
    final AtomicReference<a> kCr = new AtomicReference<>(kCq);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kCs;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kCs = i;
        }

        a cQP() {
            return new a(this.isUnsubscribed, this.kCs + 1);
        }

        a cQQ() {
            return new a(this.isUnsubscribed, this.kCs - 1);
        }

        a cQR() {
            return new a(true, this.kCs);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kCp = kVar;
    }

    public k cQN() {
        a aVar;
        AtomicReference<a> atomicReference = this.kCr;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cQT();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cQP()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kCr.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cQR;
        AtomicReference<a> atomicReference = this.kCr;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cQR = aVar.cQR();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cQR));
        a(cQR);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kCs == 0) {
            this.kCp.unsubscribe();
        }
    }

    void cQO() {
        a aVar;
        a cQQ;
        AtomicReference<a> atomicReference = this.kCr;
        do {
            aVar = atomicReference.get();
            cQQ = aVar.cQQ();
        } while (!atomicReference.compareAndSet(aVar, cQQ));
        a(cQQ);
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
                this.parent.cQO();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
