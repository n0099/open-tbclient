package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kdj = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kdi;

    public a() {
        this.kdi = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kdi = new AtomicReference<>(aVar);
    }

    public static a cFw() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kdi.get() == kdj;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kdi.get() != kdj && (andSet = this.kdi.getAndSet(kdj)) != null && andSet != kdj) {
            andSet.call();
        }
    }
}
