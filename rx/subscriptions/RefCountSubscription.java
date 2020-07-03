package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a ohT = new a(false, 0);
    private final k ohS;
    final AtomicReference<a> ohU = new AtomicReference<>(ohT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int ohV;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.ohV = i;
        }

        a dVK() {
            return new a(this.isUnsubscribed, this.ohV + 1);
        }

        a dVL() {
            return new a(this.isUnsubscribed, this.ohV - 1);
        }

        a dVM() {
            return new a(true, this.ohV);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.ohS = kVar;
    }

    public k dVI() {
        a aVar;
        AtomicReference<a> atomicReference = this.ohU;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dVO();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dVK()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ohU.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dVM;
        AtomicReference<a> atomicReference = this.ohU;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dVM = aVar.dVM();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dVM));
        a(dVM);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.ohV == 0) {
            this.ohS.unsubscribe();
        }
    }

    void dVJ() {
        a aVar;
        a dVL;
        AtomicReference<a> atomicReference = this.ohU;
        do {
            aVar = atomicReference.get();
            dVL = aVar.dVL();
        } while (!atomicReference.compareAndSet(aVar, dVL));
        a(dVL);
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
                this.parent.dVJ();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
