package rx.internal.util;

import rx.Notification;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<Notification<? super T>> iCU;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.iCU = bVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCU.call(Notification.aV(t));
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iCU.call(Notification.H(th));
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCU.call(Notification.cbm());
    }
}
