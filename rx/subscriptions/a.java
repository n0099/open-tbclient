package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kFK = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kFJ;

    public a() {
        this.kFJ = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kFJ = new AtomicReference<>(aVar);
    }

    public static a cRT() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kFJ.get() == kFK;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kFJ.get() != kFK && (andSet = this.kFJ.getAndSet(kFK)) != null && andSet != kFK) {
            andSet.call();
        }
    }
}
