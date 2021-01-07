package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes15.dex */
public final class a implements k {
    static final rx.functions.a qzl = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qzk;

    public a() {
        this.qzk = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qzk = new AtomicReference<>(aVar);
    }

    public static a ePG() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qzk.get() == qzl;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qzk.get() != qzl && (andSet = this.qzk.getAndSet(qzl)) != null && andSet != qzl) {
            andSet.call();
        }
    }
}
