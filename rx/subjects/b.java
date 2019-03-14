package rx.subjects;

import rx.b.d;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public class b<T, R> extends c<T, R> {
    private final d<T> kcO;
    private final c<T, R> kcP;

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
        this.kcP = cVar;
        this.kcO = new rx.b.d<>(cVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kcO.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kcO.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kcO.onNext(t);
    }
}
