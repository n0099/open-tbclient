package h.u;

import h.k;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes7.dex */
public final class d implements k {

    /* renamed from: e  reason: collision with root package name */
    public final SequentialSubscription f69175e = new SequentialSubscription();

    public void a(k kVar) {
        if (kVar != null) {
            this.f69175e.update(kVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69175e.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f69175e.unsubscribe();
    }
}
