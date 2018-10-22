package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iFH = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iFG;

    public a() {
        this.iFG = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iFG = new AtomicReference<>(aVar);
    }

    public static a cdN() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFG.get() == iFH;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iFG.get() != iFH && (andSet = this.iFG.getAndSet(iFH)) != null && andSet != iFH) {
            andSet.call();
        }
    }
}
