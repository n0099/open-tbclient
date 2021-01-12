package rx.subscriptions;

import rx.k;
/* loaded from: classes14.dex */
public final class e {
    private static final a quQ = new a();

    public static k eLW() {
        return rx.subscriptions.a.eLQ();
    }

    public static k eLX() {
        return quQ;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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
