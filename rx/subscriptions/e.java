package rx.subscriptions;

import rx.k;
/* loaded from: classes16.dex */
public final class e {
    private static final a qbj = new a();

    public static k eDi() {
        return rx.subscriptions.a.eDc();
    }

    public static k eDj() {
        return qbj;
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
