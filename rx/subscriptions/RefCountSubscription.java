package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nUj = new a(false, 0);
    private final k nUi;
    final AtomicReference<a> nUk = new AtomicReference<>(nUj);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nUl;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nUl = i;
        }

        a dPw() {
            return new a(this.isUnsubscribed, this.nUl + 1);
        }

        a dPx() {
            return new a(this.isUnsubscribed, this.nUl - 1);
        }

        a dPy() {
            return new a(true, this.nUl);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nUi = kVar;
    }

    public k dPu() {
        a aVar;
        AtomicReference<a> atomicReference = this.nUk;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dPA();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dPw()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUk.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dPy;
        AtomicReference<a> atomicReference = this.nUk;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dPy = aVar.dPy();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dPy));
        a(dPy);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nUl == 0) {
            this.nUi.unsubscribe();
        }
    }

    void dPv() {
        a aVar;
        a dPx;
        AtomicReference<a> atomicReference = this.nUk;
        do {
            aVar = atomicReference.get();
            dPx = aVar.dPx();
        } while (!atomicReference.compareAndSet(aVar, dPx));
        a(dPx);
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
                this.parent.dPv();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
