package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription kGt = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kGt.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kGt.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kGt.update(kVar);
    }
}
