package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iSP = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iSO;

    public a() {
        this.iSO = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iSO = new AtomicReference<>(aVar);
    }

    public static a cgL() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iSO.get() == iSP;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iSO.get() != iSP && (andSet = this.iSO.getAndSet(iSP)) != null && andSet != iSP) {
            andSet.call();
        }
    }
}
