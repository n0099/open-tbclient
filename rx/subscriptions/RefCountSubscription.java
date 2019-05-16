package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kuN = new a(false, 0);
    private final k kuM;
    final AtomicReference<a> kuO = new AtomicReference<>(kuN);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kuP;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kuP = i;
        }

        a cMX() {
            return new a(this.isUnsubscribed, this.kuP + 1);
        }

        a cMY() {
            return new a(this.isUnsubscribed, this.kuP - 1);
        }

        a cMZ() {
            return new a(true, this.kuP);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kuM = kVar;
    }

    public k cMV() {
        a aVar;
        AtomicReference<a> atomicReference = this.kuO;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cNb();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cMX()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuO.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cMZ;
        AtomicReference<a> atomicReference = this.kuO;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cMZ = aVar.cMZ();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cMZ));
        a(cMZ);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kuP == 0) {
            this.kuM.unsubscribe();
        }
    }

    void cMW() {
        a aVar;
        a cMY;
        AtomicReference<a> atomicReference = this.kuO;
        do {
            aVar = atomicReference.get();
            cMY = aVar.cMY();
        } while (!atomicReference.compareAndSet(aVar, cMY));
        a(cMY);
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
                this.parent.cMW();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
