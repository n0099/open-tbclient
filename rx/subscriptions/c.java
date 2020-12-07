package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes12.dex */
public final class c implements k {
    final SequentialSubscription pWd = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWd.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.pWd.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.pWd.replace(kVar);
    }
}
