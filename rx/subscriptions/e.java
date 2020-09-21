package rx.subscriptions;

import rx.k;
/* loaded from: classes7.dex */
public final class e {
    private static final a oUA = new a();

    public static k epz() {
        return rx.subscriptions.a.ept();
    }

    public static k epA() {
        return oUA;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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
