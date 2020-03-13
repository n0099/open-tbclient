package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nUw = new a(false, 0);
    private final k nUv;
    final AtomicReference<a> nUx = new AtomicReference<>(nUw);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nUy;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nUy = i;
        }

        a dPz() {
            return new a(this.isUnsubscribed, this.nUy + 1);
        }

        a dPA() {
            return new a(this.isUnsubscribed, this.nUy - 1);
        }

        a dPB() {
            return new a(true, this.nUy);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nUv = kVar;
    }

    public k dPx() {
        a aVar;
        AtomicReference<a> atomicReference = this.nUx;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dPD();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dPz()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUx.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dPB;
        AtomicReference<a> atomicReference = this.nUx;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dPB = aVar.dPB();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dPB));
        a(dPB);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nUy == 0) {
            this.nUv.unsubscribe();
        }
    }

    void dPy() {
        a aVar;
        a dPA;
        AtomicReference<a> atomicReference = this.nUx;
        do {
            aVar = atomicReference.get();
            dPA = aVar.dPA();
        } while (!atomicReference.compareAndSet(aVar, dPA));
        a(dPA);
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
                this.parent.dPy();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
