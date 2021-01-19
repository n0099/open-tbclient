package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes14.dex */
public final class c implements k {
    final SequentialSubscription quM = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.quM.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.quM.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.quM.replace(kVar);
    }
}
