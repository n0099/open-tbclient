package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> nFl;
    final d.b<? extends R, ? super T> nFm;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.nFl = aVar;
        this.nFm = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.nFm).call(jVar);
            call.onStart();
            this.nFl.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            jVar.onError(th);
        }
    }
}
