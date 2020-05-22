package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nKR = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nKQ;

    public a() {
        this.nKQ = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nKQ = new AtomicReference<>(aVar);
    }

    public static a dQN() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nKQ.get() == nKR;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nKQ.get() != nKR && (andSet = this.nKQ.getAndSet(nKR)) != null && andSet != nKR) {
            andSet.call();
        }
    }
}
