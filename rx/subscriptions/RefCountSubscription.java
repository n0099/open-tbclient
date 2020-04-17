package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a npU = new a(false, 0);
    private final k npT;
    final AtomicReference<a> npV = new AtomicReference<>(npU);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int npW;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.npW = i;
        }

        a dIZ() {
            return new a(this.isUnsubscribed, this.npW + 1);
        }

        a dJa() {
            return new a(this.isUnsubscribed, this.npW - 1);
        }

        a dJb() {
            return new a(true, this.npW);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.npT = kVar;
    }

    public k dIX() {
        a aVar;
        AtomicReference<a> atomicReference = this.npV;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dJd();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dIZ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.npV.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dJb;
        AtomicReference<a> atomicReference = this.npV;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dJb = aVar.dJb();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dJb));
        a(dJb);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.npW == 0) {
            this.npT.unsubscribe();
        }
    }

    void dIY() {
        a aVar;
        a dJa;
        AtomicReference<a> atomicReference = this.npV;
        do {
            aVar = atomicReference.get();
            dJa = aVar.dJa();
        } while (!atomicReference.compareAndSet(aVar, dJa));
        a(dJa);
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
                this.parent.dIY();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
