package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> ock;
    final d.b<? extends R, ? super T> ocl;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.ock = aVar;
        this.ocl = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.ocl).call(jVar);
            call.onStart();
            this.ock.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            jVar.onError(th);
        }
    }
}
