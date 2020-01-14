package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a nTr = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nTq;

    public a() {
        this.nTq = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nTq = new AtomicReference<>(aVar);
    }

    public static a dOg() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTq.get() == nTr;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nTq.get() != nTr && (andSet = this.nTq.getAndSet(nTr)) != null && andSet != nTr) {
            andSet.call();
        }
    }
}
