package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iOy = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iOx;

    public a() {
        this.iOx = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iOx = new AtomicReference<>(aVar);
    }

    public static a cfn() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iOx.get() == iOy;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iOx.get() != iOy && (andSet = this.iOx.getAndSet(iOy)) != null && andSet != iOy) {
            andSet.call();
        }
    }
}
