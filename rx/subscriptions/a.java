package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a oKx = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> oKw;

    public a() {
        this.oKw = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.oKw = new AtomicReference<>(aVar);
    }

    public static a elm() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oKw.get() == oKx;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.oKw.get() != oKx && (andSet = this.oKw.getAndSet(oKx)) != null && andSet != oKx) {
            andSet.call();
        }
    }
}
