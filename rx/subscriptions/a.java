package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a oKP = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> oKO;

    public a() {
        this.oKO = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.oKO = new AtomicReference<>(aVar);
    }

    public static a elv() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oKO.get() == oKP;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.oKO.get() != oKP && (andSet = this.oKO.getAndSet(oKP)) != null && andSet != oKP) {
            andSet.call();
        }
    }
}
