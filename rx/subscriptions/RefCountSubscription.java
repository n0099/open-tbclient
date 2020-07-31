package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a oqF = new a(false, 0);
    private final k oqE;
    final AtomicReference<a> oqG = new AtomicReference<>(oqF);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int oqH;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.oqH = i;
        }

        a dZk() {
            return new a(this.isUnsubscribed, this.oqH + 1);
        }

        a dZl() {
            return new a(this.isUnsubscribed, this.oqH - 1);
        }

        a dZm() {
            return new a(true, this.oqH);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.oqE = kVar;
    }

    public k dZi() {
        a aVar;
        AtomicReference<a> atomicReference = this.oqG;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dZo();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dZk()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oqG.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dZm;
        AtomicReference<a> atomicReference = this.oqG;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dZm = aVar.dZm();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dZm));
        a(dZm);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.oqH == 0) {
            this.oqE.unsubscribe();
        }
    }

    void dZj() {
        a aVar;
        a dZl;
        AtomicReference<a> atomicReference = this.oqG;
        do {
            aVar = atomicReference.get();
            dZl = aVar.dZl();
        } while (!atomicReference.compareAndSet(aVar, dZl));
        a(dZl);
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
                this.parent.dZj();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
