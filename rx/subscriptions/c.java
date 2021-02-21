package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes5.dex */
public final class c implements k {
    final SequentialSubscription qFp = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFp.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.qFp.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.qFp.replace(kVar);
    }
}
