package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class cl<T, U, R> implements d.b<R, T> {
    static final Object EMPTY = new Object();
    final rx.d<? extends U> iGI;
    final rx.functions.g<? super T, ? super U, ? extends R> iHf;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cl(rx.d<? extends U> dVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
        this.iGI = dVar;
        this.iHf = gVar;
    }

    public rx.j<? super T> call(rx.j<? super R> jVar) {
        final rx.b.f fVar = new rx.b.f(jVar, false);
        jVar.add(fVar);
        final AtomicReference atomicReference = new AtomicReference(EMPTY);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>(fVar, true) { // from class: rx.internal.operators.cl.1
            @Override // rx.e
            public void onNext(T t) {
                Object obj = atomicReference.get();
                if (obj != cl.EMPTY) {
                    try {
                        fVar.onNext(cl.this.iHf.j(t, obj));
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this);
                    }
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                fVar.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                fVar.onCompleted();
                fVar.unsubscribe();
            }
        };
        rx.j<U> jVar3 = new rx.j<U>() { // from class: rx.internal.operators.cl.2
            @Override // rx.e
            public void onNext(U u) {
                atomicReference.set(u);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                fVar.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                if (atomicReference.get() == cl.EMPTY) {
                    fVar.onCompleted();
                    fVar.unsubscribe();
                }
            }
        };
        fVar.add(jVar2);
        fVar.add(jVar3);
        this.iGI.unsafeSubscribe(jVar3);
        return jVar2;
    }
}
