package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes14.dex */
public final class d implements k {
    final SequentialSubscription qmc = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qmc.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qmc.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qmc.update(kVar);
    }
}
