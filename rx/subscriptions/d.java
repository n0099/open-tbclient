package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription iSR = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iSR.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.iSR.unsubscribe();
    }

    public void g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.iSR.update(kVar);
    }

    public k cgM() {
        return this.iSR.current();
    }
}
