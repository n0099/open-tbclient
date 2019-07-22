package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> kvS;
    final d.b<? extends R, ? super T> kvT;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.kvS = aVar;
        this.kvT = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.kvT).call(jVar);
            call.onStart();
            this.kvS.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            jVar.onError(th);
        }
    }
}
