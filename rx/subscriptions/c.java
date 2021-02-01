package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes5.dex */
public final class c implements k {
    final SequentialSubscription qEP = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qEP.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qEP.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qEP.replace(kVar);
    }
}
