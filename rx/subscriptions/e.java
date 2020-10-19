package rx.subscriptions;

import rx.k;
/* loaded from: classes16.dex */
public final class e {
    private static final a pjT = new a();

    public static k etk() {
        return rx.subscriptions.a.ete();
    }

    public static k etl() {
        return pjT;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
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
