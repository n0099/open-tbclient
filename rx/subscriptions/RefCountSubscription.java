package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes15.dex */
public final class RefCountSubscription implements k {
    static final a qxH = new a(false, 0);
    private final k qxG;
    final AtomicReference<a> qxI = new AtomicReference<>(qxH);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qxJ;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qxJ = i;
        }

        a ePf() {
            return new a(this.isUnsubscribed, this.qxJ + 1);
        }

        a ePg() {
            return new a(this.isUnsubscribed, this.qxJ - 1);
        }

        a ePh() {
            return new a(true, this.qxJ);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qxG = kVar;
    }

    public k ePd() {
        a aVar;
        AtomicReference<a> atomicReference = this.qxI;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.ePj();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.ePf()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qxI.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a ePh;
        AtomicReference<a> atomicReference = this.qxI;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                ePh = aVar.ePh();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, ePh));
        a(ePh);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qxJ == 0) {
            this.qxG.unsubscribe();
        }
    }

    void ePe() {
        a aVar;
        a ePg;
        AtomicReference<a> atomicReference = this.qxI;
        do {
            aVar = atomicReference.get();
            ePg = aVar.ePg();
        } while (!atomicReference.compareAndSet(aVar, ePg));
        a(ePg);
    }

    /* loaded from: classes15.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.ePe();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
