package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nKV = new a(false, 0);
    private final k nKU;
    final AtomicReference<a> nKW = new AtomicReference<>(nKV);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nKX;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nKX = i;
        }

        a dQQ() {
            return new a(this.isUnsubscribed, this.nKX + 1);
        }

        a dQR() {
            return new a(this.isUnsubscribed, this.nKX - 1);
        }

        a dQS() {
            return new a(true, this.nKX);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nKU = kVar;
    }

    public k dQO() {
        a aVar;
        AtomicReference<a> atomicReference = this.nKW;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dQU();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dQQ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nKW.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dQS;
        AtomicReference<a> atomicReference = this.nKW;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dQS = aVar.dQS();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dQS));
        a(dQS);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nKX == 0) {
            this.nKU.unsubscribe();
        }
    }

    void dQP() {
        a aVar;
        a dQR;
        AtomicReference<a> atomicReference = this.nKW;
        do {
            aVar = atomicReference.get();
            dQR = aVar.dQR();
        } while (!atomicReference.compareAndSet(aVar, dQR));
        a(dQR);
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
                this.parent.dQP();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
