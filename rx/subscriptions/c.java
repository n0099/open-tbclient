package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class c implements k {
    final SequentialSubscription iOA = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iOA.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.iOA.unsubscribe();
    }

    public void g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.iOA.replace(kVar);
    }
}
