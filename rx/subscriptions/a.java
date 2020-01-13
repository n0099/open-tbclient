package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a nTm = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nTl;

    public a() {
        this.nTl = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nTl = new AtomicReference<>(aVar);
    }

    public static a dOe() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nTl.get() == nTm;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nTl.get() != nTm && (andSet = this.nTl.getAndSet(nTm)) != null && andSet != nTm) {
            andSet.call();
        }
    }
}
