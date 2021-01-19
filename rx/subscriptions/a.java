package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes14.dex */
public final class a implements k {
    static final rx.functions.a quK = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> quJ;

    public a() {
        this.quJ = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.quJ = new AtomicReference<>(aVar);
    }

    public static a eLQ() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.quJ.get() == quK;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.quJ.get() != quK && (andSet = this.quJ.getAndSet(quK)) != null && andSet != quK) {
            andSet.call();
        }
    }
}
