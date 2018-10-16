package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iFG = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iFF;

    public a() {
        this.iFF = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iFF = new AtomicReference<>(aVar);
    }

    public static a cdN() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFF.get() == iFG;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iFF.get() != iFG && (andSet = this.iFF.getAndSet(iFG)) != null && andSet != iFG) {
            andSet.call();
        }
    }
}
