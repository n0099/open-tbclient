package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kCm = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kCl;

    public a() {
        this.kCl = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kCl = new AtomicReference<>(aVar);
    }

    public static a cQM() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kCl.get() == kCm;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kCl.get() != kCm && (andSet = this.kCl.getAndSet(kCm)) != null && andSet != kCm) {
            andSet.call();
        }
    }
}
