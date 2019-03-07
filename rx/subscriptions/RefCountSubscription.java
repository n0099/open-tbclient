package rx.subscriptions;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kcU = new a(false, 0);
    private final k kcT;
    final AtomicReference<a> kcV = new AtomicReference<>(kcU);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kcW;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kcW = i;
        }

        a cFp() {
            return new a(this.isUnsubscribed, this.kcW + 1);
        }

        a cFq() {
            return new a(this.isUnsubscribed, this.kcW - 1);
        }

        a cFr() {
            return new a(true, this.kcW);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException(NotifyType.SOUND);
        }
        this.kcT = kVar;
    }

    public k cFn() {
        a aVar;
        AtomicReference<a> atomicReference = this.kcV;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cFt();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cFp()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kcV.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cFr;
        AtomicReference<a> atomicReference = this.kcV;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cFr = aVar.cFr();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cFr));
        a(cFr);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kcW == 0) {
            this.kcT.unsubscribe();
        }
    }

    void cFo() {
        a aVar;
        a cFq;
        AtomicReference<a> atomicReference = this.kcV;
        do {
            aVar = atomicReference.get();
            cFq = aVar.cFq();
        } while (!atomicReference.compareAndSet(aVar, cFq));
        a(cFq);
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
                this.parent.cFo();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
