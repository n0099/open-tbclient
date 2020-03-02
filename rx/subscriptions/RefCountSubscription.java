package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a nUl = new a(false, 0);
    private final k nUk;
    final AtomicReference<a> nUm = new AtomicReference<>(nUl);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nUn;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nUn = i;
        }

        a dPy() {
            return new a(this.isUnsubscribed, this.nUn + 1);
        }

        a dPz() {
            return new a(this.isUnsubscribed, this.nUn - 1);
        }

        a dPA() {
            return new a(true, this.nUn);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nUk = kVar;
    }

    public k dPw() {
        a aVar;
        AtomicReference<a> atomicReference = this.nUm;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dPC();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dPy()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUm.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dPA;
        AtomicReference<a> atomicReference = this.nUm;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dPA = aVar.dPA();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dPA));
        a(dPA);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nUn == 0) {
            this.nUk.unsubscribe();
        }
    }

    void dPx() {
        a aVar;
        a dPz;
        AtomicReference<a> atomicReference = this.nUm;
        do {
            aVar = atomicReference.get();
            dPz = aVar.dPz();
        } while (!atomicReference.compareAndSet(aVar, dPz));
        a(dPz);
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
                this.parent.dPx();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
