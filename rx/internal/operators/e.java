package rx.internal.operators;

import rx.d;
/* loaded from: classes5.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> oER;
    final d.b<? extends R, ? super T> oES;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.oER = aVar;
        this.oES = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.oES).call(jVar);
            call.onStart();
            this.oER.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
