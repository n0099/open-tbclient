package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes4.dex */
public final class RefCountSubscription implements k {
    static final a qFT = new a(false, 0);
    private final k qFS;
    final AtomicReference<a> qFU = new AtomicReference<>(qFT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qFV;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qFV = i;
        }

        a eNZ() {
            return new a(this.isUnsubscribed, this.qFV + 1);
        }

        a eOa() {
            return new a(this.isUnsubscribed, this.qFV - 1);
        }

        a eOb() {
            return new a(true, this.qFV);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qFS = kVar;
    }

    public k eNX() {
        a aVar;
        AtomicReference<a> atomicReference = this.qFU;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eOd();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eNZ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFU.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eOb;
        AtomicReference<a> atomicReference = this.qFU;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eOb = aVar.eOb();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eOb));
        a(eOb);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qFV == 0) {
            this.qFS.unsubscribe();
        }
    }

    void eNY() {
        a aVar;
        a eOa;
        AtomicReference<a> atomicReference = this.qFU;
        do {
            aVar = atomicReference.get();
            eOa = aVar.eOa();
        } while (!atomicReference.compareAndSet(aVar, eOa));
        a(eOa);
    }

    /* loaded from: classes4.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.eNY();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
