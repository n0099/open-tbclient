package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a ohS = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> ohR;

    public a() {
        this.ohR = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.ohR = new AtomicReference<>(aVar);
    }

    public static a dVL() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ohR.get() == ohS;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.ohR.get() != ohS && (andSet = this.ohR.getAndSet(ohS)) != null && andSet != ohS) {
            andSet.call();
        }
    }
}
