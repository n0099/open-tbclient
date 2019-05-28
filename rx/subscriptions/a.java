package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kuK = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kuJ;

    public a() {
        this.kuJ = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kuJ = new AtomicReference<>(aVar);
    }

    public static a cMW() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuJ.get() == kuK;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kuJ.get() != kuK && (andSet = this.kuJ.getAndSet(kuK)) != null && andSet != kuK) {
            andSet.call();
        }
    }
}
