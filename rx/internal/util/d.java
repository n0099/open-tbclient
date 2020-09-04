package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> oIZ;

    public d(rx.e<? super T> eVar) {
        this.oIZ = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oIZ.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oIZ.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oIZ.onCompleted();
    }
}
