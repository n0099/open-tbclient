package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes4.dex */
public final class a implements k {
    static final rx.functions.a nkp = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nko;

    public a() {
        this.nko = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nko = new AtomicReference<>(aVar);
    }

    public static a dHD() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nko.get() == nkp;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nko.get() != nkp && (andSet = this.nko.getAndSet(nkp)) != null && andSet != nkp) {
            andSet.call();
        }
    }
}
