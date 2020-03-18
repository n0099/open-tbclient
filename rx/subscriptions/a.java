package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nWf = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nWe;

    public a() {
        this.nWe = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nWe = new AtomicReference<>(aVar);
    }

    public static a dPW() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nWe.get() == nWf;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nWe.get() != nWf && (andSet = this.nWe.getAndSet(nWf)) != null && andSet != nWf) {
            andSet.call();
        }
    }
}
