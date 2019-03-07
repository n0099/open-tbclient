package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> jWv;
    final d.b<? extends R, ? super T> jWw;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.jWv = aVar;
        this.jWw = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.jWw).call(jVar);
            call.onStart();
            this.jWv.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            jVar.onError(th);
        }
    }
}
