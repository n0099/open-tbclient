package rx.internal.operators;

import rx.d;
/* loaded from: classes15.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> qtI;
    final d.b<? extends R, ? super T> qtJ;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.qtI = aVar;
        this.qtJ = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.qtJ).call(jVar);
            call.onStart();
            this.qtI.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.O(th);
            jVar.onError(th);
        }
    }
}
