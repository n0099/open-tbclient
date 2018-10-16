package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class w<T> implements d.a<T> {
    private final Throwable exception;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public w(Throwable th) {
        this.exception = th;
    }

    public void call(rx.j<? super T> jVar) {
        jVar.onError(this.exception);
    }
}
