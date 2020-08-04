package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a oqH = new a(false, 0);
    private final k oqG;
    final AtomicReference<a> oqI = new AtomicReference<>(oqH);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int oqJ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.oqJ = i;
        }

        a dZl() {
            return new a(this.isUnsubscribed, this.oqJ + 1);
        }

        a dZm() {
            return new a(this.isUnsubscribed, this.oqJ - 1);
        }

        a dZn() {
            return new a(true, this.oqJ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.oqG = kVar;
    }

    public k dZj() {
        a aVar;
        AtomicReference<a> atomicReference = this.oqI;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dZp();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dZl()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oqI.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dZn;
        AtomicReference<a> atomicReference = this.oqI;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dZn = aVar.dZn();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dZn));
        a(dZn);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.oqJ == 0) {
            this.oqG.unsubscribe();
        }
    }

    void dZk() {
        a aVar;
        a dZm;
        AtomicReference<a> atomicReference = this.oqI;
        do {
            aVar = atomicReference.get();
            dZm = aVar.dZm();
        } while (!atomicReference.compareAndSet(aVar, dZm));
        a(dZm);
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
                this.parent.dZk();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
