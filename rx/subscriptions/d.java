package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes12.dex */
public final class d implements k {
    final SequentialSubscription pWf = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWf.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.pWf.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.pWf.update(kVar);
    }
}
