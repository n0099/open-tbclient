package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes5.dex */
public final class c implements k {
    final SequentialSubscription oKR = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oKR.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.oKR.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.oKR.replace(kVar);
    }
}
