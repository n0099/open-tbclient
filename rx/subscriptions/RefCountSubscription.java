package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements k {
    static final a iRM = new a(false, 0);
    private final k iRL;
    final AtomicReference<a> iRN = new AtomicReference<>(iRM);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        final int iRO;
        final boolean isUnsubscribed;

        a(boolean z, int i) {
            this.isUnsubscribed = z;
            this.iRO = i;
        }

        a cgg() {
            return new a(this.isUnsubscribed, this.iRO + 1);
        }

        a cgh() {
            return new a(this.isUnsubscribed, this.iRO - 1);
        }

        a cgi() {
            return new a(true, this.iRO);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.iRL = kVar;
    }

    public k cge() {
        a aVar;
        AtomicReference<a> atomicReference = this.iRN;
        do {
            aVar = atomicReference.get();
            if (aVar.isUnsubscribed) {
                return e.cgk();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.cgg()));
        return new InnerSubscription(this);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iRN.get().isUnsubscribed;
    }

    @Override // rx.k
    public void unsubscribe() {
        a aVar;
        a cgi;
        AtomicReference<a> atomicReference = this.iRN;
        do {
            aVar = atomicReference.get();
            if (!aVar.isUnsubscribed) {
                cgi = aVar.cgi();
            } else {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, cgi));
        a(cgi);
    }

    private void a(a aVar) {
        if (aVar.isUnsubscribed && aVar.iRO == 0) {
            this.iRL.unsubscribe();
        }
    }

    void cgf() {
        a aVar;
        a cgh;
        AtomicReference<a> atomicReference = this.iRN;
        do {
            aVar = atomicReference.get();
            cgh = aVar.cgh();
        } while (!atomicReference.compareAndSet(aVar, cgh));
        a(cgh);
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
                this.parent.cgf();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }
    }
}
