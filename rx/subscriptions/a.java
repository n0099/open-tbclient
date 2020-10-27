package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class a implements k {
    static final rx.functions.a qbc = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qbb;

    public a() {
        this.qbb = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qbb = new AtomicReference<>(aVar);
    }

    public static a eDc() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qbb.get() == qbc;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qbb.get() != qbc && (andSet = this.qbb.getAndSet(qbc)) != null && andSet != qbc) {
            andSet.call();
        }
    }
}
