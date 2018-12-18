package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iOC = new a(false, 0);
    private final k iOB;
    final AtomicReference<a> iOD = new AtomicReference<>(iOC);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iOE;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iOE = i;
        }

        a cfp() {
            return new a(this.isUnsubscribed, this.iOE + 1);
        }

        a cfq() {
            return new a(this.isUnsubscribed, this.iOE - 1);
        }

        a cfr() {
            return new a(true, this.iOE);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iOB = kVar;
    }

    public k cfn() {
        a aVar;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cft();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cfp()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iOD.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cfr;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cfr = aVar.cfr();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cfr));
        a(cfr);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iOE == 0) {
            this.iOB.unsubscribe();
        }
    }

    void cfo() {
        a aVar;
        a cfq;
        AtomicReference<a> atomicReference = this.iOD;
        do {
            aVar = atomicReference.get();
            cfq = aVar.cfq();
        } while (!atomicReference.compareAndSet(aVar, cfq));
        a(cfq);
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
                this.parent.cfo();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
