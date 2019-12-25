package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes4.dex */
public final class RefCountSubscription implements k {
    static final a nkt = new a(false, 0);
    private final k nks;
    final AtomicReference<a> nku = new AtomicReference<>(nkt);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nkv;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nkv = i;
        }

        a dHG() {
            return new a(this.isUnsubscribed, this.nkv + 1);
        }

        a dHH() {
            return new a(this.isUnsubscribed, this.nkv - 1);
        }

        a dHI() {
            return new a(true, this.nkv);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nks = kVar;
    }

    public k dHE() {
        a aVar;
        AtomicReference<a> atomicReference = this.nku;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dHK();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dHG()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nku.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dHI;
        AtomicReference<a> atomicReference = this.nku;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dHI = aVar.dHI();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dHI));
        a(dHI);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nkv == 0) {
            this.nks.unsubscribe();
        }
    }

    void dHF() {
        a aVar;
        a dHH;
        AtomicReference<a> atomicReference = this.nku;
        do {
            aVar = atomicReference.get();
            dHH = aVar.dHH();
        } while (!atomicReference.compareAndSet(aVar, dHH));
        a(dHH);
    }

    /* loaded from: classes4.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.dHF();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
