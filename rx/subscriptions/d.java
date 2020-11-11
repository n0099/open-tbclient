package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes16.dex */
public final class d implements k {
    final SequentialSubscription qkz = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qkz.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qkz.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qkz.update(kVar);
    }
}
