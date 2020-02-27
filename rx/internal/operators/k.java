package rx.internal.operators;

import rx.d;
/* loaded from: classes6.dex */
public final class k<T> implements d.b<T, T> {
    final rx.functions.a action;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public k(rx.functions.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Action can not be null");
        }
        this.action = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.k.1
            @Override // rx.e
            public void onNext(T t) {
                jVar.onNext(t);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                try {
                    jVar.onError(th);
                } finally {
                    dOl();
                }
            }

            @Override // rx.e
            public void onCompleted() {
                try {
                    jVar.onCompleted();
                } finally {
                    dOl();
                }
            }

            void dOl() {
                try {
                    k.this.action.call();
                } catch (Throwable th) {
                    rx.exceptions.a.H(th);
                    rx.c.c.onError(th);
                }
            }
        };
    }
}
