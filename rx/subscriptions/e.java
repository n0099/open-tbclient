package rx.subscriptions;

import rx.k;
/* loaded from: classes5.dex */
public final class e {
    private static final a qEU = new a();

    public static k eOm() {
        return rx.subscriptions.a.eOg();
    }

    public static k eOn() {
        return qEU;
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
