package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes5.dex */
public final class a implements k {
    static final rx.functions.a qFn = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qFm;

    public a() {
        this.qFm = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qFm = new AtomicReference<>(aVar);
    }

    public static a eOo() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qFm.get() == qFn;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qFm.get() != qFn && (andSet = this.qFm.getAndSet(qFn)) != null && andSet != qFn) {
            andSet.call();
        }
    }
}
