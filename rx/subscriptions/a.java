package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a oqB = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> oqA;

    public a() {
        this.oqA = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.oqA = new AtomicReference<>(aVar);
    }

    public static a dZh() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oqA.get() == oqB;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.oqA.get() != oqB && (andSet = this.oqA.getAndSet(oqB)) != null && andSet != oqB) {
            andSet.call();
        }
    }
}
