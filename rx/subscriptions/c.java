package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes15.dex */
public final class c implements k {
    final SequentialSubscription qzn = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qzn.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qzn.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qzn.replace(kVar);
    }
}
