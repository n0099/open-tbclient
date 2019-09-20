package rx.subscriptions;

import rx.k;
/* loaded from: classes2.dex */
public final class e {
    private static final a kFR = new a();

    public static k cRZ() {
        return rx.subscriptions.a.cRT();
    }

    public static k cSa() {
        return kFR;
    }

    public static k l(rx.functions.a aVar) {
        return rx.subscriptions.a.k(aVar);
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
