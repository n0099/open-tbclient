package rx.internal.operators;

import rx.d;
/* loaded from: classes5.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> nNN;
    final d.b<? extends R, ? super T> nNO;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.nNN = aVar;
        this.nNO = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.nNO).call(jVar);
            call.onStart();
            this.nNN.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.I(th);
            jVar.onError(th);
        }
    }
}
