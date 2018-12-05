package rx.internal.a;

import rx.b.h;
import rx.f;
import rx.j;
/* loaded from: classes2.dex */
public class a<T> extends j<T> implements rx.b.a<T> {
    private final h<T> iBA;

    public a(h<T> hVar) {
        this.iBA = hVar;
    }

    public static <T> a<T> dA(long j) {
        h hVar = new h(j);
        a<T> aVar = new a<>(hVar);
        aVar.add(hVar);
        return aVar;
    }

    @Override // rx.j
    public void onStart() {
        this.iBA.onStart();
    }

    @Override // rx.e
    public void onCompleted() {
        this.iBA.onCompleted();
    }

    @Override // rx.j
    public void setProducer(f fVar) {
        this.iBA.setProducer(fVar);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iBA.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iBA.onNext(t);
    }

    public String toString() {
        return this.iBA.toString();
    }
}
