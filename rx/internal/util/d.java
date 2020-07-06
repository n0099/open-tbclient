package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ogc;

    public d(rx.e<? super T> eVar) {
        this.ogc = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ogc.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ogc.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ogc.onCompleted();
    }
}
