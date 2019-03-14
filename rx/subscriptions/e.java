package rx.subscriptions;

import rx.k;
/* loaded from: classes2.dex */
public final class e {
    private static final a kdi = new a();

    public static k cFF() {
        return rx.subscriptions.a.cFz();
    }

    public static k cFG() {
        return kdi;
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
