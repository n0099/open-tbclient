package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kdb = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kda;

    public a() {
        this.kda = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kda = new AtomicReference<>(aVar);
    }

    public static a cFz() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kda.get() == kdb;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kda.get() != kdb && (andSet = this.kda.getAndSet(kdb)) != null && andSet != kdb) {
            andSet.call();
        }
    }
}
