package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class RefCountSubscription implements k {
    static final a npX = new a(false, 0);
    private final k npW;
    final AtomicReference<a> npY = new AtomicReference<>(npX);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int npZ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.npZ = i;
        }

        a dIV() {
            return new a(this.isUnsubscribed, this.npZ + 1);
        }

        a dIW() {
            return new a(this.isUnsubscribed, this.npZ - 1);
        }

        a dIX() {
            return new a(true, this.npZ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.npW = kVar;
    }

    public k dIT() {
        a aVar;
        AtomicReference<a> atomicReference = this.npY;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dIZ();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dIV()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.npY.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dIX;
        AtomicReference<a> atomicReference = this.npY;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dIX = aVar.dIX();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dIX));
        a(dIX);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.npZ == 0) {
            this.npW.unsubscribe();
        }
    }

    void dIU() {
        a aVar;
        a dIW;
        AtomicReference<a> atomicReference = this.npY;
        do {
            aVar = atomicReference.get();
            dIW = aVar.dIW();
        } while (!atomicReference.compareAndSet(aVar, dIW));
        a(dIW);
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
                this.parent.dIU();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
