package rx.internal.util;

import rx.Notification;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<Notification<? super T>> iCT;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.iCT = bVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCT.call(Notification.aV(t));
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iCT.call(Notification.H(th));
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCT.call(Notification.cbm());
    }
}
