package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes7.dex */
public final class a implements k {
    static final rx.functions.a oUt = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> oUs;

    public a() {
        this.oUs = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.oUs = new AtomicReference<>(aVar);
    }

    public static a ept() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oUs.get() == oUt;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.oUs.get() != oUt && (andSet = this.oUs.getAndSet(oUt)) != null && andSet != oUt) {
            andSet.call();
        }
    }
}
