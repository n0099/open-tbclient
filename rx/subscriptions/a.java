package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a npT = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> npS;

    public a() {
        this.npS = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.npS = new AtomicReference<>(aVar);
    }

    public static a dIS() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.npS.get() == npT;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.npS.get() != npT && (andSet = this.npS.getAndSet(npT)) != null && andSet != npT) {
            andSet.call();
        }
    }
}
