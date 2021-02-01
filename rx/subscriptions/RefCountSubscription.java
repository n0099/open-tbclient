package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class RefCountSubscription implements k {
    static final a qER = new a(false, 0);
    private final k qEQ;
    final AtomicReference<a> qES = new AtomicReference<>(qER);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int qET;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.qET = i;
        }

        a eOj() {
            return new a(this.isUnsubscribed, this.qET + 1);
        }

        a eOk() {
            return new a(this.isUnsubscribed, this.qET - 1);
        }

        a eOl() {
            return new a(true, this.qET);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.qEQ = kVar;
    }

    public k eOh() {
        a aVar;
        AtomicReference<a> atomicReference = this.qES;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.eOn();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.eOj()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qES.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a eOl;
        AtomicReference<a> atomicReference = this.qES;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                eOl = aVar.eOl();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, eOl));
        a(eOl);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.qET == 0) {
            this.qEQ.unsubscribe();
        }
    }

    void eOi() {
        a aVar;
        a eOk;
        AtomicReference<a> atomicReference = this.qES;
        do {
            aVar = atomicReference.get();
            eOk = aVar.eOk();
        } while (!atomicReference.compareAndSet(aVar, eOk));
        a(eOk);
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
                this.parent.eOi();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
