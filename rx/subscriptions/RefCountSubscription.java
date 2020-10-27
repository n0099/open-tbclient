package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class RefCountSubscription implements k {
    static final a qbg = new a(false, 0);
    private final k qbf;
    final AtomicReference<a> qbh = new AtomicReference<>(qbg);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qbi;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qbi = i;
        }

        a eDf() {
            return new a(this.isUnsubscribed, this.qbi + 1);
        }

        a eDg() {
            return new a(this.isUnsubscribed, this.qbi - 1);
        }

        a eDh() {
            return new a(true, this.qbi);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qbf = kVar;
    }

    public k eDd() {
        a aVar;
        AtomicReference<a> atomicReference = this.qbh;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eDj();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eDf()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qbh.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eDh;
        AtomicReference<a> atomicReference = this.qbh;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eDh = aVar.eDh();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eDh));
        a(eDh);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qbi == 0) {
            this.qbf.unsubscribe();
        }
    }

    void eDe() {
        a aVar;
        a eDg;
        AtomicReference<a> atomicReference = this.qbh;
        do {
            aVar = atomicReference.get();
            eDg = aVar.eDg();
        } while (!atomicReference.compareAndSet(aVar, eDg));
        a(eDg);
    }

    /* loaded from: classes16.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.eDe();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
