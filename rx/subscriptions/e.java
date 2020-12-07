package rx.subscriptions;

import rx.k;
/* loaded from: classes12.dex */
public final class e {
    private static final a pWi = new a();

    public static k eGZ() {
        return rx.subscriptions.a.eGT();
    }

    public static k eHa() {
        return pWi;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
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
