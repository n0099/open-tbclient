package rx.subscriptions;

import rx.k;
/* loaded from: classes2.dex */
public final class e {
    private static final a iHy = new a();

    public static k cdq() {
        return rx.subscriptions.a.cdk();
    }

    public static k cdr() {
        return iHy;
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
