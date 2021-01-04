package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes15.dex */
public final class a implements k {
    static final rx.functions.a qxD = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qxC;

    public a() {
        this.qxC = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qxC = new AtomicReference<>(aVar);
    }

    public static a ePc() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qxC.get() == qxD;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qxC.get() != qxD && (andSet = this.qxC.getAndSet(qxD)) != null && andSet != qxD) {
            andSet.call();
        }
    }
}
