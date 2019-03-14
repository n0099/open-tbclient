package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription kdd = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kdd.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kdd.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kdd.update(kVar);
    }
}
