package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a oqD = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> oqC;

    public a() {
        this.oqC = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.oqC = new AtomicReference<>(aVar);
    }

    public static a dZi() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oqC.get() == oqD;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.oqC.get() != oqD && (andSet = this.oqC.getAndSet(oqD)) != null && andSet != oqD) {
            andSet.call();
        }
    }
}
