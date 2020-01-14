package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes5.dex */
public final class d implements k {
    final SequentialSubscription nTt = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTt.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.nTt.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.nTt.update(kVar);
    }
}
