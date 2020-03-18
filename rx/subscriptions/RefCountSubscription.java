package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nWj = new a(false, 0);
    private final k nWi;
    final AtomicReference<a> nWk = new AtomicReference<>(nWj);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nWl;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nWl = i;
        }

        a dPZ() {
            return new a(this.isUnsubscribed, this.nWl + 1);
        }

        a dQa() {
            return new a(this.isUnsubscribed, this.nWl - 1);
        }

        a dQb() {
            return new a(true, this.nWl);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nWi = kVar;
    }

    public k dPX() {
        a aVar;
        AtomicReference<a> atomicReference = this.nWk;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dQd();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dPZ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nWk.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dQb;
        AtomicReference<a> atomicReference = this.nWk;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dQb = aVar.dQb();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dQb));
        a(dQb);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nWl == 0) {
            this.nWi.unsubscribe();
        }
    }

    void dPY() {
        a aVar;
        a dQa;
        AtomicReference<a> atomicReference = this.nWk;
        do {
            aVar = atomicReference.get();
            dQa = aVar.dQa();
        } while (!atomicReference.compareAndSet(aVar, dQa));
        a(dQa);
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
                this.parent.dPY();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
