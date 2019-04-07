package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kcx = new a(false, 0);
    private final k kcw;
    final AtomicReference<a> kcy = new AtomicReference<>(kcx);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kcz;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kcz = i;
        }

        a cFr() {
            return new a(this.isUnsubscribed, this.kcz + 1);
        }

        a cFs() {
            return new a(this.isUnsubscribed, this.kcz - 1);
        }

        a cFt() {
            return new a(true, this.kcz);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kcw = kVar;
    }

    public k cFp() {
        a aVar;
        AtomicReference<a> atomicReference = this.kcy;
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
        return this.kcy.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cFt;
        AtomicReference<a> atomicReference = this.kcy;
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
        if (aVar.isUnsubscribed && aVar.kcz == 0) {
            this.kcw.unsubscribe();
        }
    }

    void cFq() {
        a aVar;
        a cFs;
        AtomicReference<a> atomicReference = this.kcy;
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
