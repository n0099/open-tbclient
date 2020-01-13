package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class RefCountSubscription implements k {
    static final a nTq = new a(false, 0);
    private final k nTp;
    final AtomicReference<a> nTr = new AtomicReference<>(nTq);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nTs;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nTs = i;
        }

        a dOh() {
            return new a(this.isUnsubscribed, this.nTs + 1);
        }

        a dOi() {
            return new a(this.isUnsubscribed, this.nTs - 1);
        }

        a dOj() {
            return new a(true, this.nTs);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nTp = kVar;
    }

    public k dOf() {
        a aVar;
        AtomicReference<a> atomicReference = this.nTr;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dOl();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dOh()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTr.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dOj;
        AtomicReference<a> atomicReference = this.nTr;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dOj = aVar.dOj();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dOj));
        a(dOj);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nTs == 0) {
            this.nTp.unsubscribe();
        }
    }

    void dOg() {
        a aVar;
        a dOi;
        AtomicReference<a> atomicReference = this.nTr;
        do {
            aVar = atomicReference.get();
            dOi = aVar.dOi();
        } while (!atomicReference.compareAndSet(aVar, dOi));
        a(dOi);
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
                this.parent.dOg();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
