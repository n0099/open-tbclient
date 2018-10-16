package rx.internal.operators;

import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public class cg<T> implements d.b<T, T> {
    final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cg(rx.g gVar) {
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        final rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.cg.1
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
                jVar.onNext(t);
            }
        };
        jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.cg.2
            @Override // rx.functions.a
            public void call() {
                final g.a createWorker = cg.this.scheduler.createWorker();
                createWorker.a(new rx.functions.a() { // from class: rx.internal.operators.cg.2.1
                    @Override // rx.functions.a
                    public void call() {
                        jVar2.unsubscribe();
                        createWorker.unsubscribe();
                    }
                });
            }
        }));
        return jVar2;
    }
}
