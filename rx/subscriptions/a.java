package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes6.dex */
public final class a implements k {
    static final rx.functions.a nUs = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> nUr;

    public a() {
        this.nUr = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.nUr = new AtomicReference<>(aVar);
    }

    public static a dPw() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nUr.get() == nUs;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.nUr.get() != nUs && (andSet = this.nUr.getAndSet(nUs)) != null && andSet != nUs) {
            andSet.call();
        }
    }
}
