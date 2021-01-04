package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes15.dex */
public final class d implements k {
    final SequentialSubscription qxF = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qxF.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qxF.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qxF.update(kVar);
    }
}
