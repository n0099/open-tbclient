package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> jWO;
    final d.b<? extends R, ? super T> jWP;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.jWO = aVar;
        this.jWP = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.jWP).call(jVar);
            call.onStart();
            this.jWO.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            jVar.onError(th);
        }
    }
}
