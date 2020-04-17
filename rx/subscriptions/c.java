package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes6.dex */
public final class c implements k {
    final SequentialSubscription npS = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.npS.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.npS.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.npS.replace(kVar);
    }
}
