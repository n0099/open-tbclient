package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kDs = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kDr;

    public a() {
        this.kDr = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kDr = new AtomicReference<>(aVar);
    }

    public static a cRh() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kDr.get() == kDs;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kDr.get() != kDs && (andSet = this.kDr.getAndSet(kDs)) != null && andSet != kDs) {
            andSet.call();
        }
    }
}
