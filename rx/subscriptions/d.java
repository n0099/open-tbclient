package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription kFC = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kFC.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kFC.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kFC.update(kVar);
    }
}
