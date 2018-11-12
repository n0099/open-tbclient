package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iHv = new a(false, 0);
    private final k iHu;
    final AtomicReference<a> iHw = new AtomicReference<>(iHv);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iHx;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iHx = i;
        }

        a cdn() {
            return new a(this.isUnsubscribed, this.iHx + 1);
        }

        a cdo() {
            return new a(this.isUnsubscribed, this.iHx - 1);
        }

        a cdp() {
            return new a(true, this.iHx);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iHu = kVar;
    }

    public k cdl() {
        a aVar;
        AtomicReference<a> atomicReference = this.iHw;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cdr();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cdn()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iHw.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cdp;
        AtomicReference<a> atomicReference = this.iHw;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cdp = aVar.cdp();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cdp));
        a(cdp);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iHx == 0) {
            this.iHu.unsubscribe();
        }
    }

    void cdm() {
        a aVar;
        a cdo;
        AtomicReference<a> atomicReference = this.iHw;
        do {
            aVar = atomicReference.get();
            cdo = aVar.cdo();
        } while (!atomicReference.compareAndSet(aVar, cdo));
        a(cdo);
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
                this.parent.cdm();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
