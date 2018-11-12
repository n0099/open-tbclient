package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iHr = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iHq;

    public a() {
        this.iHq = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iHq = new AtomicReference<>(aVar);
    }

    public static a cdk() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iHq.get() == iHr;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iHq.get() != iHr && (andSet = this.iHq.getAndSet(iHr)) != null && andSet != iHr) {
            andSet.call();
        }
    }
}
