package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes12.dex */
public final class a implements k {
    static final rx.functions.a pWd = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> pWc;

    public a() {
        this.pWc = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.pWc = new AtomicReference<>(aVar);
    }

    public static a eGU() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWc.get() == pWd;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.pWc.get() != pWd && (andSet = this.pWc.getAndSet(pWd)) != null && andSet != pWd) {
            andSet.call();
        }
    }
}
