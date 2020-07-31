package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes6.dex */
public final class d implements k {
    final SequentialSubscription oqD = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oqD.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.oqD.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.oqD.update(kVar);
    }
}
