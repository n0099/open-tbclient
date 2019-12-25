package rx.internal.subscriptions;

import rx.k;
/* loaded from: classes4.dex */
public enum Unsubscribed implements k {
    INSTANCE;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.k
    public void unsubscribe() {
    }
}
