package rx.subscriptions;

import rx.k;
/* loaded from: classes15.dex */
public final class e {
    private static final a qxK = new a();

    public static k ePi() {
        return rx.subscriptions.a.ePc();
    }

    public static k ePj() {
        return qxK;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
