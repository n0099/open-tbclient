package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iST = new a(false, 0);
    private final k iSS;
    final AtomicReference<a> iSU = new AtomicReference<>(iST);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iSV;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iSV = i;
        }

        a cgO() {
            return new a(this.isUnsubscribed, this.iSV + 1);
        }

        a cgP() {
            return new a(this.isUnsubscribed, this.iSV - 1);
        }

        a cgQ() {
            return new a(true, this.iSV);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iSS = kVar;
    }

    public k cgM() {
        a aVar;
        AtomicReference<a> atomicReference = this.iSU;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cgS();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cgO()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iSU.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cgQ;
        AtomicReference<a> atomicReference = this.iSU;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cgQ = aVar.cgQ();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cgQ));
        a(cgQ);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iSV == 0) {
            this.iSS.unsubscribe();
        }
    }

    void cgN() {
        a aVar;
        a cgP;
        AtomicReference<a> atomicReference = this.iSU;
        do {
            aVar = atomicReference.get();
            cgP = aVar.cgP();
        } while (!atomicReference.compareAndSet(aVar, cgP));
        a(cgP);
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
                this.parent.cgN();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
