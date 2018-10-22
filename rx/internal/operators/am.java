package rx.internal.operators;

import rx.d;
import rx.subjects.PublishSubject;
/* loaded from: classes2.dex */
public final class am<T, V> implements d.b<T, T> {
    final rx.d<? extends T> isM;
    final rx.functions.f<? super T, ? extends rx.d<V>> ivY;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public am(rx.d<? extends T> dVar, rx.functions.f<? super T, ? extends rx.d<V>> fVar) {
        this.isM = dVar;
        this.ivY = fVar;
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final rx.b.f fVar = new rx.b.f(jVar);
        final PublishSubject cdJ = PublishSubject.cdJ();
        jVar.add(rx.d.merge(cdJ).unsafeSubscribe(rx.b.g.a(fVar)));
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.am.1
            @Override // rx.e
            public void onCompleted() {
                cdJ.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.subjects.PublishSubject */
            /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.functions.f<V, T>, rx.functions.f<? super V, ? extends R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public void onNext(final T t) {
                try {
                    cdJ.onNext(am.this.ivY.call(t).take(1).defaultIfEmpty(null).map((rx.functions.f<V, T>) new rx.functions.f<V, T>() { // from class: rx.internal.operators.am.1.1
                        @Override // rx.functions.f
                        public T call(V v) {
                            return (T) t;
                        }
                    }));
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }
        };
    }
}
