package rx.internal.operators;

import rx.d;
/* loaded from: classes12.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> pQw;
    final d.b<? extends R, ? super T> pQx;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.pQw = aVar;
        this.pQx = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.pQx).call(jVar);
            call.onStart();
            this.pQw.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
