package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class RefCountSubscription implements k {
    static final a qFr = new a(false, 0);
    private final k qFq;
    final AtomicReference<a> qFs = new AtomicReference<>(qFr);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qFt;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qFt = i;
        }

        a eOr() {
            return new a(this.isUnsubscribed, this.qFt + 1);
        }

        a eOs() {
            return new a(this.isUnsubscribed, this.qFt - 1);
        }

        a eOt() {
            return new a(true, this.qFt);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qFq = kVar;
    }

    public k eOp() {
        a aVar;
        AtomicReference<a> atomicReference = this.qFs;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eOv();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eOr()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFs.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eOt;
        AtomicReference<a> atomicReference = this.qFs;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eOt = aVar.eOt();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eOt));
        a(eOt);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qFt == 0) {
            this.qFq.unsubscribe();
        }
    }

    void eOq() {
        a aVar;
        a eOs;
        AtomicReference<a> atomicReference = this.qFs;
        do {
            aVar = atomicReference.get();
            eOs = aVar.eOs();
        } while (!atomicReference.compareAndSet(aVar, eOs));
        a(eOs);
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
                this.parent.eOq();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
