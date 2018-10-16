package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class h<T, U> implements d.a<T> {
    final rx.d<? extends T> itw;
    final rx.d<U> itx;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public h(rx.d<? extends T> dVar, rx.d<U> dVar2) {
        this.itw = dVar;
        this.itx = dVar2;
    }

    public void call(rx.j<? super T> jVar) {
        final rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        final rx.j b = rx.b.g.b(jVar);
        rx.j<U> jVar2 = new rx.j<U>() { // from class: rx.internal.operators.h.1
            boolean done;

            @Override // rx.e
            public void onNext(U u) {
                onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (this.done) {
                    rx.c.c.onError(th);
                    return;
                }
                this.done = true;
                b.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    dVar.g(rx.subscriptions.e.cdU());
                    h.this.itw.unsafeSubscribe(b);
                }
            }
        };
        dVar.g(jVar2);
        this.itx.unsafeSubscribe(jVar2);
    }
}
