package rx.subjects;

import rx.b.d;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public class b<T, R> extends c<T, R> {
    private final d<T> kcg;
    private final c<T, R> kch;

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
        this.kch = cVar;
        this.kcg = new rx.b.d<>(cVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kcg.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kcg.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kcg.onNext(t);
    }
}
