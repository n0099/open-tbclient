package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
/* loaded from: classes2.dex */
public final class a implements k {
    static final rx.functions.a kuN = new rx.functions.a() { // from class: rx.subscriptions.a.1
        @Override // rx.functions.a
        public void call() {
        }
    };
    final AtomicReference<rx.functions.a> kuM;

    public a() {
        this.kuM = new AtomicReference<>();
    }

    private a(rx.functions.a aVar) {
        this.kuM = new AtomicReference<>(aVar);
    }

    public static a cMV() {
        return new a();
    }

    public static a k(rx.functions.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kuM.get() == kuN;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.functions.a andSet;
        if (this.kuM.get() != kuN && (andSet = this.kuM.getAndSet(kuN)) != null && andSet != kuN) {
            andSet.call();
        }
    }
}
