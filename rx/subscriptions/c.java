package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes4.dex */
public final class c implements k {
    final SequentialSubscription qFR = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFR.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qFR.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qFR.replace(kVar);
    }
}
