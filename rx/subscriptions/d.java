package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes16.dex */
public final class d implements k {
    final SequentialSubscription qbe = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qbe.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qbe.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qbe.update(kVar);
    }
}
