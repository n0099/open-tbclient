package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kuJ = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kuI;

    public a() {
        this.kuI = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kuI = new AtomicReference<>(aVar);
    }

    public static a cMU() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuI.get() == kuJ;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kuI.get() != kuJ && (andSet = this.kuI.getAndSet(kuJ)) != null && andSet != kuJ) {
            andSet.call();
        }
    }
}
