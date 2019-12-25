package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes4.dex */
public final class d implements k {
    final SequentialSubscription nkr = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nkr.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.nkr.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.nkr.update(kVar);
    }
}
