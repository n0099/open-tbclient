package h.u;

import h.k;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes8.dex */
public final class c implements k {

    /* renamed from: e  reason: collision with root package name */
    public final SequentialSubscription f72017e = new SequentialSubscription();

    public void a(k kVar) {
        if (kVar != null) {
            this.f72017e.replace(kVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72017e.isUnsubscribed();
    }

    @Override // h.k
    public void unsubscribe() {
        this.f72017e.unsubscribe();
    }
}
