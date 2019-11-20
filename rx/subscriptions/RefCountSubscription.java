package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kFE = new a(false, 0);
    private final k kFD;
    final AtomicReference<a> kFF = new AtomicReference<>(kFE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kFG;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kFG = i;
        }

        a cPZ() {
            return new a(this.isUnsubscribed, this.kFG + 1);
        }

        a cQa() {
            return new a(this.isUnsubscribed, this.kFG - 1);
        }

        a cQb() {
            return new a(true, this.kFG);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kFD = kVar;
    }

    public k cPX() {
        a aVar;
        AtomicReference<a> atomicReference = this.kFF;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cQd();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cPZ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kFF.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cQb;
        AtomicReference<a> atomicReference = this.kFF;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cQb = aVar.cQb();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cQb));
        a(cQb);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kFG == 0) {
            this.kFD.unsubscribe();
        }
    }

    void cPY() {
        a aVar;
        a cQa;
        AtomicReference<a> atomicReference = this.kFF;
        do {
            aVar = atomicReference.get();
            cQa = aVar.cQa();
        } while (!atomicReference.compareAndSet(aVar, cQa));
        a(cQa);
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
                this.parent.cPY();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
