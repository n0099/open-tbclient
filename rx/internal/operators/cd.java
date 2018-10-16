package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class cd<T> implements d.b<rx.schedulers.b<T>, T> {
    final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cd(rx.g gVar) {
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super rx.schedulers.b<T>> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.cd.1
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
                jVar.onNext(new rx.schedulers.b(cd.this.scheduler.now(), t));
            }
        };
    }
}
