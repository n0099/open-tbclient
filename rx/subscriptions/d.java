package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription iFI = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFI.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.iFI.unsubscribe();
    }

    public void g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.iFI.update(kVar);
    }

    public k cdO() {
        return this.iFI.current();
    }
}
