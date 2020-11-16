package rx.internal.operators;

import rx.d;
/* loaded from: classes14.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> qgu;
    final d.b<? extends R, ? super T> qgv;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.qgu = aVar;
        this.qgv = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.qgv).call(jVar);
            call.onStart();
            this.qgu.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
