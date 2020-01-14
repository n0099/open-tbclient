package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class RefCountSubscription implements k {
    static final a nTv = new a(false, 0);
    private final k nTu;
    final AtomicReference<a> nTw = new AtomicReference<>(nTv);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int nTx;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.nTx = i;
        }

        a dOj() {
            return new a(this.isUnsubscribed, this.nTx + 1);
        }

        a dOk() {
            return new a(this.isUnsubscribed, this.nTx - 1);
        }

        a dOl() {
            return new a(true, this.nTx);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.nTu = kVar;
    }

    public k dOh() {
        a aVar;
        AtomicReference<a> atomicReference = this.nTw;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.dOn();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.dOj()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTw.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a dOl;
        AtomicReference<a> atomicReference = this.nTw;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                dOl = aVar.dOl();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, dOl));
        a(dOl);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.nTx == 0) {
            this.nTu.unsubscribe();
        }
    }

    void dOi() {
        a aVar;
        a dOk;
        AtomicReference<a> atomicReference = this.nTw;
        do {
            aVar = atomicReference.get();
            dOk = aVar.dOk();
        } while (!atomicReference.compareAndSet(aVar, dOk));
        a(dOk);
    }

    /* loaded from: classes5.dex */
    static final class InnerSubscription extends AtomicInteger implements k {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.dOi();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
