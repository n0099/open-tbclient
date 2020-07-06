package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes6.dex */
public final class c implements k {
    final SequentialSubscription ohU = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ohU.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.ohU.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.ohU.replace(kVar);
    }
}
