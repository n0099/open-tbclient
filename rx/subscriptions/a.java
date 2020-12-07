package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes12.dex */
public final class a implements k {
    static final rx.functions.a pWb = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> pWa;

    public a() {
        this.pWa = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.pWa = new AtomicReference<>(aVar);
    }

    public static a eGT() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pWa.get() == pWb;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.pWa.get() != pWb && (andSet = this.pWa.getAndSet(pWb)) != null && andSet != pWb) {
            andSet.call();
        }
    }
}
