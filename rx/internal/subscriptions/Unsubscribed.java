package rx.internal.subscriptions;

import h.k;
/* loaded from: classes8.dex */
public enum Unsubscribed implements k {
    INSTANCE;

    @Override // h.k
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // h.k
    public void unsubscribe() {
    }
}
