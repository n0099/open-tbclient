package rx.subjects;

import rx.b.d;
import rx.d;
import rx.j;
/* loaded from: classes16.dex */
public class b<T, R> extends c<T, R> {
    private final d<T> qaR;
    private final c<T, R> qaS;

    public b(final c<T, R> cVar) {
        super(new d.a<R>() { // from class: rx.subjects.b.1
            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((j) ((j) obj));
            }

            public void call(j<? super R> jVar) {
                c.this.a((j) jVar);
            }
        });
        this.qaS = cVar;
        this.qaR = new rx.b.d<>(cVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qaR.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qaR.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qaR.onNext(t);
    }
}
