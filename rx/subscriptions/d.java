package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription kCo = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kCo.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kCo.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kCo.update(kVar);
    }
}
