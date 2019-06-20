package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kuR = new a(false, 0);
    private final k kuQ;
    final AtomicReference<a> kuS = new AtomicReference<>(kuR);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kuT;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kuT = i;
        }

        a cMY() {
            return new a(this.isUnsubscribed, this.kuT + 1);
        }

        a cMZ() {
            return new a(this.isUnsubscribed, this.kuT - 1);
        }

        a cNa() {
            return new a(true, this.kuT);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kuQ = kVar;
    }

    public k cMW() {
        a aVar;
        AtomicReference<a> atomicReference = this.kuS;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cNc();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cMY()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuS.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cNa;
        AtomicReference<a> atomicReference = this.kuS;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cNa = aVar.cNa();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cNa));
        a(cNa);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kuT == 0) {
            this.kuQ.unsubscribe();
        }
    }

    void cMX() {
        a aVar;
        a cMZ;
        AtomicReference<a> atomicReference = this.kuS;
        do {
            aVar = atomicReference.get();
            cMZ = aVar.cMZ();
        } while (!atomicReference.compareAndSet(aVar, cMZ));
        a(cMZ);
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
                this.parent.cMX();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
