package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bj<T> implements d.b<T, T> {
    final int iMj;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bj(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + i);
        }
        this.iMj = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bj.1
            int iMk;

            @Override // rx.e
            public void onCompleted() {
                jVar.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                if (this.iMk >= bj.this.iMj) {
                    jVar.onNext(t);
                } else {
                    this.iMk++;
                }
            }

            @Override // rx.j
            public void setProducer(rx.f fVar) {
                jVar.setProducer(fVar);
                fVar.request(bj.this.iMj);
            }
        };
    }
}
