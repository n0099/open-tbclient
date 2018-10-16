package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iFK = new a(false, 0);
    private final k iFJ;
    final AtomicReference<a> iFL = new AtomicReference<>(iFK);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iFM;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iFM = i;
        }

        a cdQ() {
            return new a(this.isUnsubscribed, this.iFM + 1);
        }

        a cdR() {
            return new a(this.isUnsubscribed, this.iFM - 1);
        }

        a cdS() {
            return new a(true, this.iFM);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iFJ = kVar;
    }

    public k cdO() {
        a aVar;
        AtomicReference<a> atomicReference = this.iFL;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cdU();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cdQ()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFL.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cdS;
        AtomicReference<a> atomicReference = this.iFL;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cdS = aVar.cdS();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cdS));
        a(cdS);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iFM == 0) {
            this.iFJ.unsubscribe();
        }
    }

    void cdP() {
        a aVar;
        a cdR;
        AtomicReference<a> atomicReference = this.iFL;
        do {
            aVar = atomicReference.get();
            cdR = aVar.cdR();
        } while (!atomicReference.compareAndSet(aVar, cdR));
        a(cdR);
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
                this.parent.cdP();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
