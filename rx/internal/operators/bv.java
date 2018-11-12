package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bv<T, E> implements d.b<T, T> {
    private final rx.d<? extends E> ivi;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bv(rx.d<? extends E> dVar) {
        this.ivi = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final rx.b.f fVar = new rx.b.f(jVar, false);
        final rx.j jVar2 = (rx.j<T>) new rx.j<T>(fVar, false) { // from class: rx.internal.operators.bv.1
            @Override // rx.e
            public void onNext(T t) {
                fVar.onNext(t);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                try {
                    fVar.onError(th);
                } finally {
                    fVar.unsubscribe();
                }
            }

            @Override // rx.e
            public void onCompleted() {
                try {
                    fVar.onCompleted();
                } finally {
                    fVar.unsubscribe();
                }
            }
        };
        rx.j<E> jVar3 = new rx.j<E>() { // from class: rx.internal.operators.bv.2
            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onCompleted() {
                jVar2.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar2.onError(th);
            }

            @Override // rx.e
            public void onNext(E e) {
                onCompleted();
            }
        };
        fVar.add(jVar2);
        fVar.add(jVar3);
        jVar.add(fVar);
        this.ivi.unsafeSubscribe(jVar3);
        return jVar2;
    }
}
