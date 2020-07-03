package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a ohP = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> ohO;

    public a() {
        this.ohO = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.ohO = new AtomicReference<>(aVar);
    }

    public static a dVH() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ohO.get() == ohP;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.ohO.get() != ohP && (andSet = this.ohO.getAndSet(ohP)) != null && andSet != ohP) {
            andSet.call();
        }
    }
}
