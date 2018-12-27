package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class i<T, U> implements d.a<T> {
    final rx.d<? extends T> iEP;
    final rx.functions.e<? extends rx.d<U>> iFF;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public i(rx.d<? extends T> dVar, rx.functions.e<? extends rx.d<U>> eVar) {
        this.iEP = dVar;
        this.iFF = eVar;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.j<U>, rx.j<? super U> */
    public void call(final rx.j<? super T> jVar) {
        try {
            this.iFF.call().take(1).unsafeSubscribe((rx.j<U>) new rx.j<U>() { // from class: rx.internal.operators.i.1
                @Override // rx.e
                public void onCompleted() {
                    i.this.iEP.unsafeSubscribe(rx.b.g.b(jVar));
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    jVar.onError(th);
                }

                @Override // rx.e
                public void onNext(U u) {
                }
            });
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }
}
