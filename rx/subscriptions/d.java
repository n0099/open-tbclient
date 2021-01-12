package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes14.dex */
public final class d implements k {
    final SequentialSubscription quL = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.quL.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.quL.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.quL.update(kVar);
    }
}
