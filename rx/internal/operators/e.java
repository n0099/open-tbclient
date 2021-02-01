package rx.internal.operators;

import rx.d;
/* loaded from: classes5.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> qzk;
    final d.b<? extends R, ? super T> qzl;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.qzk = aVar;
        this.qzl = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.qzl).call(jVar);
            call.onStart();
            this.qzk.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.N(th);
            jVar.onError(th);
        }
    }
}
