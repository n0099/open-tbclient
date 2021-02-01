package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a qEN = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qEM;

    public a() {
        this.qEM = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qEM = new AtomicReference<>(aVar);
    }

    public static a eOg() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qEM.get() == qEN;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qEM.get() != qEN && (andSet = this.qEM.getAndSet(qEN)) != null && andSet != qEN) {
            andSet.call();
        }
    }
}
