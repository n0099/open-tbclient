package rx.subjects;

import rx.b.d;
import rx.d;
import rx.j;
/* loaded from: classes12.dex */
public class b<T, R> extends c<T, R> {
    private final d<T> pVS;
    private final c<T, R> pVT;

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
        this.pVT = cVar;
        this.pVS = new rx.b.d<>(cVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pVS.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pVS.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pVS.onNext(t);
    }
}
