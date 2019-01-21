package rx.internal.util;

import rx.Notification;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<Notification<? super T>> iQd;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.iQd = bVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQd.call(Notification.aV(t));
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iQd.call(Notification.H(th));
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQd.call(Notification.cek());
    }
}
