package rx.internal.operators;

import rx.d;
/* loaded from: classes16.dex */
public final class e<T, R> implements d.a<R> {
    final d.a<T> pee;
    final d.b<? extends R, ? super T> pef;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public e(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.pee = aVar;
        this.pef = bVar;
    }

    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.c.c.b(this.pef).call(jVar);
            call.onStart();
            this.pee.call(call);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }
}
