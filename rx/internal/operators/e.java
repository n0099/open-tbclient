package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> okT;
    final d.b<? extends R, ? super T> okU;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.okT = aVar;
        this.okU = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.okU).call(jVar);
            call.onStart();
            this.okT.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            jVar.onError(th);
        }
    }
}
