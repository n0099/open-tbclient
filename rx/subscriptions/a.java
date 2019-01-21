package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iSQ = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iSP;

    public a() {
        this.iSP = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iSP = new AtomicReference<>(aVar);
    }

    public static a cgL() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iSP.get() == iSQ;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iSP.get() != iSQ && (andSet = this.iSP.getAndSet(iSQ)) != null && andSet != iSQ) {
            andSet.call();
        }
    }
}
