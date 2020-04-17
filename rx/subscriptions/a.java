package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a npQ = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> npP;

    public a() {
        this.npP = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.npP = new AtomicReference<>(aVar);
    }

    public static a dIW() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.npP.get() == npQ;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.npP.get() != npQ && (andSet = this.npP.getAndSet(npQ)) != null && andSet != npQ) {
            andSet.call();
        }
    }
}
