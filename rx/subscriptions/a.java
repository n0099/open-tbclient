package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kcQ = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kcP;

    public a() {
        this.kcP = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kcP = new AtomicReference<>(aVar);
    }

    public static a cFm() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kcP.get() == kcQ;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kcP.get() != kcQ && (andSet = this.kcP.getAndSet(kcQ)) != null && andSet != kcQ) {
            andSet.call();
        }
    }
}
