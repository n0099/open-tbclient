package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> okV;
    final d.b<? extends R, ? super T> okW;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.okV = aVar;
        this.okW = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.okW).call(jVar);
            call.onStart();
            this.okV.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            jVar.onError(th);
        }
    }
}
