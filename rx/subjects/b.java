package rx.subjects;

import rx.b.e;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public class b<T, R> extends c<T, R> {
    private final c<T, R> actual;
    private final e<T> observer;

    public b(final c<T, R> cVar) {
        super(new d.a<R>() { // from class: rx.subjects.b.1
            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((j) ((j) obj));
            }

            public void call(j<? super R> jVar) {
                c.this.unsafeSubscribe(jVar);
            }
        });
        this.actual = cVar;
        this.observer = new e<>(cVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.observer.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.observer.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.observer.onNext(t);
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }
}
