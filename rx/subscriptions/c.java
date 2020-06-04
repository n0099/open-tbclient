package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes6.dex */
public final class c implements k {
    final SequentialSubscription nMd = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMd.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.nMd.unsubscribe();
    }

    public void f(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.nMd.replace(kVar);
    }
}
