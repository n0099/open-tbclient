package rx.internal.util;

import rx.Notification;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<Notification<? super T>> iLL;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.iLL = bVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iLL.call(Notification.aV(t));
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iLL.call(Notification.H(th));
    }

    @Override // rx.e
    public void onCompleted() {
        this.iLL.call(Notification.ccL());
    }
}
