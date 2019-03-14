package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kdf = new a(false, 0);
    private final k kde;
    final AtomicReference<a> kdg = new AtomicReference<>(kdf);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kdh;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kdh = i;
        }

        a cFC() {
            return new a(this.isUnsubscribed, this.kdh + 1);
        }

        a cFD() {
            return new a(this.isUnsubscribed, this.kdh - 1);
        }

        a cFE() {
            return new a(true, this.kdh);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.kde = kVar;
    }

    public k cFA() {
        a aVar;
        AtomicReference<a> atomicReference = this.kdg;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cFG();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cFC()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kdg.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cFE;
        AtomicReference<a> atomicReference = this.kdg;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cFE = aVar.cFE();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cFE));
        a(cFE);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kdh == 0) {
            this.kde.unsubscribe();
        }
    }

    void cFB() {
        a aVar;
        a cFD;
        AtomicReference<a> atomicReference = this.kdg;
        do {
            aVar = atomicReference.get();
            cFD = aVar.cFD();
        } while (!atomicReference.compareAndSet(aVar, cFD));
        a(cFD);
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
                this.parent.cFB();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
