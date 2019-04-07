package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kct = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kcs;

    public a() {
        this.kcs = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kcs = new AtomicReference<>(aVar);
    }

    public static a cFo() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kcs.get() == kct;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kcs.get() != kct && (andSet = this.kcs.getAndSet(kct)) != null && andSet != kct) {
            andSet.call();
        }
    }
}
