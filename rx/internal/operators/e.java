package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> nOC;
    final d.b<? extends R, ? super T> nOD;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.nOC = aVar;
        this.nOD = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.nOD).call(jVar);
            call.onStart();
            this.nOC.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.H(th);
            jVar.onError(th);
        }
    }
}
