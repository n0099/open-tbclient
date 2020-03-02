package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nUh = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nUg;

    public a() {
        this.nUg = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nUg = new AtomicReference<>(aVar);
    }

    public static a dPv() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUg.get() == nUh;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nUg.get() != nUh && (andSet = this.nUg.getAndSet(nUh)) != null && andSet != nUh) {
            andSet.call();
        }
    }
}
