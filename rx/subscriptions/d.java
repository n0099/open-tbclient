package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.k;
/* loaded from: classes2.dex */
public final class d implements k {
    final SequentialSubscription iSS = new SequentialSubscription();

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iSS.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.iSS.unsubscribe();
    }

    public void g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.iSS.update(kVar);
    }

    public k cgM() {
        return this.iSS.current();
    }
}
