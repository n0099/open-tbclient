package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes16.dex */
public final class a implements k {
    static final rx.functions.a pjM = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> pjL;

    public a() {
        this.pjL = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.pjL = new AtomicReference<>(aVar);
    }

    public static a ete() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pjL.get() == pjM;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.pjL.get() != pjM && (andSet = this.pjL.getAndSet(pjM)) != null && andSet != pjM) {
            andSet.call();
        }
    }
}
