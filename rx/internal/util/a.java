package rx.internal.util;

import rx.Notification;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<Notification<? super T>> iEE;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.iEE = bVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iEE.call(Notification.aU(t));
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iEE.call(Notification.H(th));
    }

    @Override // rx.e
    public void onCompleted() {
        this.iEE.call(Notification.caJ());
    }
}
