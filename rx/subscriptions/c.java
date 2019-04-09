package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class c implements k {
    final SequentialSubscription kcw = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kcw.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.kcw.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.kcw.replace(kVar);
    }
}
