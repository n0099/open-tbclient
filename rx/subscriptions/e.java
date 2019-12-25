package rx.subscriptions;

import rx.k;
/* loaded from: classes4.dex */
public final class e {
    private static final a nkw = new a();

    public static k dHJ() {
        return rx.subscriptions.a.dHD();
    }

    public static k dHK() {
        return nkw;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
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
