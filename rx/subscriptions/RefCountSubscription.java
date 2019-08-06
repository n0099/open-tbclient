package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kDw = new a(false, 0);
    private final k kDv;
    final AtomicReference<a> kDx = new AtomicReference<>(kDw);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kDy;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kDy = i;
        }

        a cRk() {
            return new a(this.isUnsubscribed, this.kDy + 1);
        }

        a cRl() {
            return new a(this.isUnsubscribed, this.kDy - 1);
        }

        a cRm() {
            return new a(true, this.kDy);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kDv = kVar;
    }

    public k cRi() {
        a aVar;
        AtomicReference<a> atomicReference = this.kDx;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cRo();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cRk()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kDx.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cRm;
        AtomicReference<a> atomicReference = this.kDx;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cRm = aVar.cRm();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cRm));
        a(cRm);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kDy == 0) {
            this.kDv.unsubscribe();
        }
    }

    void cRj() {
        a aVar;
        a cRl;
        AtomicReference<a> atomicReference = this.kDx;
        do {
            aVar = atomicReference.get();
            cRl = aVar.cRl();
        } while (!atomicReference.compareAndSet(aVar, cRl));
        a(cRl);
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
                this.parent.cRj();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
