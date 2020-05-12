package rx.subscriptions;

import rx.k;
/* loaded from: classes6.dex */
public final class e {
    private static final a nqa = new a();

    public static k dIZ() {
        return rx.subscriptions.a.dIT();
    }

    public static k dJa() {
        return nqa;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
