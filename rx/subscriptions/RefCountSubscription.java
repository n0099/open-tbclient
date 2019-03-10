package rx.subscriptions;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a kdn = new a(false, 0);
    private final k kdm;
    final AtomicReference<a> kdo = new AtomicReference<>(kdn);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final boolean isUnsubscribed;
        final int kdp;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.kdp = i;
        }

        a cFz() {
            return new a(this.isUnsubscribed, this.kdp + 1);
        }

        a cFA() {
            return new a(this.isUnsubscribed, this.kdp - 1);
        }

        a cFB() {
            return new a(true, this.kdp);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException(NotifyType.SOUND);
        }
        this.kdm = kVar;
    }

    public k cFx() {
        a aVar;
        AtomicReference<a> atomicReference = this.kdo;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cFD();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cFz()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kdo.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cFB;
        AtomicReference<a> atomicReference = this.kdo;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cFB = aVar.cFB();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cFB));
        a(cFB);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.kdp == 0) {
            this.kdm.unsubscribe();
        }
    }

    void cFy() {
        a aVar;
        a cFA;
        AtomicReference<a> atomicReference = this.kdo;
        do {
            aVar = atomicReference.get();
            cFA = aVar.cFA();
        } while (!atomicReference.compareAndSet(aVar, cFA));
        a(cFA);
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
                this.parent.cFy();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
