package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kcy = new a(false, 0);
    private final k kcx;
    final AtomicReference<a> kcz = new AtomicReference<>(kcy);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kcA;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kcA = i;
        }

        a cFr() {
            return new a(this.isUnsubscribed, this.kcA + 1);
        }

        a cFs() {
            return new a(this.isUnsubscribed, this.kcA - 1);
        }

        a cFt() {
            return new a(true, this.kcA);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kcx = kVar;
    }

    public k cFp() {
        a aVar;
        AtomicReference<a> atomicReference = this.kcz;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cFv();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cFr()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kcz.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cFt;
        AtomicReference<a> atomicReference = this.kcz;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cFt = aVar.cFt();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cFt));
        a(cFt);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kcA == 0) {
            this.kcx.unsubscribe();
        }
    }

    void cFq() {
        a aVar;
        a cFs;
        AtomicReference<a> atomicReference = this.kcz;
        do {
            aVar = atomicReference.get();
            cFs = aVar.cFs();
        } while (!atomicReference.compareAndSet(aVar, cFs));
        a(cFs);
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
                this.parent.cFq();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
