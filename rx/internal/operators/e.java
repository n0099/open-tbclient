package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> nOP;
    final d.b<? extends R, ? super T> nOQ;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.nOP = aVar;
        this.nOQ = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.nOQ).call(jVar);
            call.onStart();
            this.nOP.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.H(th);
            jVar.onError(th);
        }
    }
}
