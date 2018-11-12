package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class bd<T, U> implements d.b<T, T> {
    static final Object iAp = new Object();
    final rx.d<U> iAo;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bd(rx.d<U> dVar) {
        this.iAo = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final rx.b.f fVar = new rx.b.f(jVar);
        final AtomicReference atomicReference = new AtomicReference(iAp);
        final AtomicReference atomicReference2 = new AtomicReference();
        final rx.j<U> jVar2 = new rx.j<U>() { // from class: rx.internal.operators.bd.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: rx.b.f */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public void onNext(U u) {
                Object andSet = atomicReference.getAndSet(bd.iAp);
                if (andSet != bd.iAp) {
                    fVar.onNext(andSet);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                ((rx.k) atomicReference2.get()).unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                onNext(null);
                fVar.onCompleted();
                ((rx.k) atomicReference2.get()).unsubscribe();
            }
        };
        rx.j jVar3 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.bd.2
            @Override // rx.e
            public void onNext(T t) {
                atomicReference.set(t);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                jVar2.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                jVar2.onNext(null);
                fVar.onCompleted();
                jVar2.unsubscribe();
            }
        };
        atomicReference2.lazySet(jVar3);
        jVar.add(jVar3);
        jVar.add(jVar2);
        this.iAo.unsafeSubscribe(jVar2);
        return jVar3;
    }
}
