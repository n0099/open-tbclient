package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a iRI = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> iRH;

    public a() {
        this.iRH = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.iRH = new AtomicReference<>(aVar);
    }

    public static a cgd() {
        return new a();
    }

    public static a i(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iRH.get() == iRI;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.iRH.get() != iRI && (andSet = this.iRH.getAndSet(iRI)) != null && andSet != iRI) {
            andSet.call();
        }
    }
}
