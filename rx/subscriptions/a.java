package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kcu = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kct;

    public a() {
        this.kct = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kct = new AtomicReference<>(aVar);
    }

    public static a cFo() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kct.get() == kcu;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kct.get() != kcu && (andSet = this.kct.getAndSet(kcu)) != null && andSet != kcu) {
            andSet.call();
        }
    }
}
