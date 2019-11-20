package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kFA = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kFz;

    public a() {
        this.kFz = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kFz = new AtomicReference<>(aVar);
    }

    public static a cPW() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kFz.get() == kFA;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kFz.get() != kFA && (andSet = this.kFz.getAndSet(kFA)) != null && andSet != kFA) {
            andSet.call();
        }
    }
}
