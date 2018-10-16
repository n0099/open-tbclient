package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.d;
/* loaded from: classes2.dex */
public final class bm<T, U> implements d.b<T, T> {
    final rx.d<U> itx;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bm(rx.d<U> dVar) {
        this.itx = dVar;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final rx.b.f fVar = new rx.b.f(jVar);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        rx.j<U> jVar2 = new rx.j<U>() { // from class: rx.internal.operators.bm.1
            @Override // rx.e
            public void onNext(U u) {
                atomicBoolean.set(true);
                unsubscribe();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                fVar.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                unsubscribe();
            }
        };
        jVar.add(jVar2);
        this.itx.unsafeSubscribe(jVar2);
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bm.2
            @Override // rx.e
            public void onNext(T t) {
                if (atomicBoolean.get()) {
                    fVar.onNext(t);
                } else {
                    request(1L);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                fVar.onError(th);
                unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                fVar.onCompleted();
                unsubscribe();
            }
        };
    }
}
