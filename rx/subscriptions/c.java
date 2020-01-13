package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes5.dex */
public final class c implements k {
    final SequentialSubscription nTo = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTo.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.nTo.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.nTo.replace(kVar);
    }
}
