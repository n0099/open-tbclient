package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kGr = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kGq;

    public a() {
        this.kGq = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kGq = new AtomicReference<>(aVar);
    }

    public static a cPY() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kGq.get() == kGr;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kGq.get() != kGr && (andSet = this.kGq.getAndSet(kGr)) != null && andSet != kGr) {
            andSet.call();
        }
    }
}
