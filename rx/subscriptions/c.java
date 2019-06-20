package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class c implements k {
    final SequentialSubscription kuP = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuP.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kuP.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kuP.replace(kVar);
    }
}
