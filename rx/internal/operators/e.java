package rx.internal.operators;

import rx.d;
/* loaded from: classes16.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> qeR;
    final d.b<? extends R, ? super T> qeS;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.qeR = aVar;
        this.qeS = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.qeS).call(jVar);
            call.onStart();
            this.qeR.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
