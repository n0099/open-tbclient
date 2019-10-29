package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> kzY;
    final d.b<? extends R, ? super T> kzZ;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.kzY = aVar;
        this.kzZ = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.kzZ).call(jVar);
            call.onStart();
            this.kzY.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
