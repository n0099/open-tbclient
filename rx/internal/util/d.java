package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> oIH;

    public d(rx.e<? super T> eVar) {
        this.oIH = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oIH.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oIH.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oIH.onCompleted();
    }
}
