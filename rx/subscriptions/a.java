package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nMb = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nMa;

    public a() {
        this.nMa = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nMa = new AtomicReference<>(aVar);
    }

    public static a dRb() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMa.get() == nMb;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nMa.get() != nMb && (andSet = this.nMa.getAndSet(nMb)) != null && andSet != nMb) {
            andSet.call();
        }
    }
}
