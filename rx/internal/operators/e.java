package rx.internal.operators;

import rx.d;
/* loaded from: classes16.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> pVx;
    final d.b<? extends R, ? super T> pVy;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.pVx = aVar;
        this.pVy = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.pVy).call(jVar);
            call.onStart();
            this.pVx.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
