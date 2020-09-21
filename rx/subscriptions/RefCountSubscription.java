package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes7.dex */
public final class RefCountSubscription implements k {
    static final a oUx = new a(false, 0);
    private final k oUw;
    final AtomicReference<a> oUy = new AtomicReference<>(oUx);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int oUz;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.oUz = i;
        }

        a epw() {
            return new a(this.isUnsubscribed, this.oUz + 1);
        }

        a epx() {
            return new a(this.isUnsubscribed, this.oUz - 1);
        }

        a epy() {
            return new a(true, this.oUz);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.oUw = kVar;
    }

    public k epu() {
        a aVar;
        AtomicReference<a> atomicReference = this.oUy;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.epA();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.epw()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oUy.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a epy;
        AtomicReference<a> atomicReference = this.oUy;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                epy = aVar.epy();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, epy));
        a(epy);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.oUz == 0) {
            this.oUw.unsubscribe();
        }
    }

    void epv() {
        a aVar;
        a epx;
        AtomicReference<a> atomicReference = this.oUy;
        do {
            aVar = atomicReference.get();
            epx = aVar.epx();
        } while (!atomicReference.compareAndSet(aVar, epx));
        a(epx);
    }

    /* loaded from: classes7.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.epv();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
