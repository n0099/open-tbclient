package rx.subscriptions;

import rx.k;
/* loaded from: classes2.dex */
public final class e {
    private static final a iSW = new a();

    public static k cgR() {
        return rx.subscriptions.a.cgL();
    }

    public static k cgS() {
        return iSW;
    }

    public static k j(rx.functions.a aVar) {
        return rx.subscriptions.a.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
