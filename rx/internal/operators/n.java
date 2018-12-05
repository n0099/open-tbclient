package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class n<T, R> implements d.a<R> {
    final d.a<T> iCZ;
    final d.b<? extends R, ? super T> iDa;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public n(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.iCZ = aVar;
        this.iDa = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.a(this.iDa).call(jVar);
            call.onStart();
            this.iCZ.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
