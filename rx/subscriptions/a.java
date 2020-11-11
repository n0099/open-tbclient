package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class a implements k {
    static final rx.functions.a qkx = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> qkw;

    public a() {
        this.qkw = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.qkw = new AtomicReference<>(aVar);
    }

    public static a eGR() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qkw.get() == qkx;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.qkw.get() != qkx && (andSet = this.qkw.getAndSet(qkx)) != null && andSet != qkx) {
            andSet.call();
        }
    }
}
