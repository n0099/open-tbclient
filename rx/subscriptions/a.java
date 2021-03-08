package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes4.dex */
public final class a implements k {
    static final rx.functions.a qFP = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qFO;

    public a() {
        this.qFO = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qFO = new AtomicReference<>(aVar);
    }

    public static a eNW() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFO.get() == qFP;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qFO.get() != qFP && (andSet = this.qFO.getAndSet(qFP)) != null && andSet != qFP) {
            andSet.call();
        }
    }
}
