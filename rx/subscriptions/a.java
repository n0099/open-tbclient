package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes14.dex */
public final class a implements k {
    static final rx.functions.a quJ = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> quI;

    public a() {
        this.quI = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.quI = new AtomicReference<>(aVar);
    }

    public static a eLQ() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.quI.get() == quJ;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.quI.get() != quJ && (andSet = this.quI.getAndSet(quJ)) != null && andSet != quJ) {
            andSet.call();
        }
    }
}
