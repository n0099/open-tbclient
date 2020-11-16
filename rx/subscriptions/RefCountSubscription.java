package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes14.dex */
public final class RefCountSubscription implements k {
    static final a qme = new a(false, 0);
    private final k qmd;
    final AtomicReference<a> qmf = new AtomicReference<>(qme);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qmg;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qmg = i;
        }

        a eGV() {
            return new a(this.isUnsubscribed, this.qmg + 1);
        }

        a eGW() {
            return new a(this.isUnsubscribed, this.qmg - 1);
        }

        a eGX() {
            return new a(true, this.qmg);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qmd = kVar;
    }

    public k eGT() {
        a aVar;
        AtomicReference<a> atomicReference = this.qmf;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eGZ();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eGV()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qmf.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eGX;
        AtomicReference<a> atomicReference = this.qmf;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eGX = aVar.eGX();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eGX));
        a(eGX);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qmg == 0) {
            this.qmd.unsubscribe();
        }
    }

    void eGU() {
        a aVar;
        a eGW;
        AtomicReference<a> atomicReference = this.qmf;
        do {
            aVar = atomicReference.get();
            eGW = aVar.eGW();
        } while (!atomicReference.compareAndSet(aVar, eGW));
        a(eGW);
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
                this.parent.eGU();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
