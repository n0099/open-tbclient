package rx.subscriptions;

import rx.k;
/* loaded from: classes5.dex */
public final class e {
    private static final a oKE = new a();

    public static k els() {
        return rx.subscriptions.a.elm();
    }

    public static k elt() {
        return oKE;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements k {
        a() {
        }

        @Override // rx.k
        public void unsubscribe() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return true;
        }
    }
}
