package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes7.dex */
public final class c implements k {
    final SequentialSubscription oUv = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oUv.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.oUv.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.oUv.replace(kVar);
    }
}
