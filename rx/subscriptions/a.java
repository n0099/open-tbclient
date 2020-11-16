package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes14.dex */
public final class a implements k {
    static final rx.functions.a qma = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qlZ;

    public a() {
        this.qlZ = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qlZ = new AtomicReference<>(aVar);
    }

    public static a eGS() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qlZ.get() == qma;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qlZ.get() != qma && (andSet = this.qlZ.getAndSet(qma)) != null && andSet != qma) {
            andSet.call();
        }
    }
}
