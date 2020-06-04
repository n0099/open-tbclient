package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nMf = new a(false, 0);
    private final k nMe;
    final AtomicReference<a> nMg = new AtomicReference<>(nMf);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nMh;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nMh = i;
        }

        a dRe() {
            return new a(this.isUnsubscribed, this.nMh + 1);
        }

        a dRf() {
            return new a(this.isUnsubscribed, this.nMh - 1);
        }

        a dRg() {
            return new a(true, this.nMh);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nMe = kVar;
    }

    public k dRc() {
        a aVar;
        AtomicReference<a> atomicReference = this.nMg;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dRi();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dRe()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMg.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dRg;
        AtomicReference<a> atomicReference = this.nMg;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dRg = aVar.dRg();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dRg));
        a(dRg);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nMh == 0) {
            this.nMe.unsubscribe();
        }
    }

    void dRd() {
        a aVar;
        a dRf;
        AtomicReference<a> atomicReference = this.nMg;
        do {
            aVar = atomicReference.get();
            dRf = aVar.dRf();
        } while (!atomicReference.compareAndSet(aVar, dRf));
        a(dRf);
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
                this.parent.dRd();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
