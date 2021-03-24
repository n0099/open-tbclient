package h.u;

import h.k;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes7.dex */
public final class d implements k {

    /* renamed from: e  reason: collision with root package name */
    public final SequentialSubscription f68013e = new SequentialSubscription();

    public void a(k kVar) {
        if (kVar != null) {
            this.f68013e.update(kVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f68013e.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f68013e.unsubscribe();
    }
}
