package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nUf = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nUe;

    public a() {
        this.nUe = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nUe = new AtomicReference<>(aVar);
    }

    public static a dPt() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUe.get() == nUf;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nUe.get() != nUf && (andSet = this.nUe.getAndSet(nUf)) != null && andSet != nUf) {
            andSet.call();
        }
    }
}
