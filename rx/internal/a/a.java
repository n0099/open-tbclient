package rx.internal.a;

import rx.b.h;
import rx.f;
import rx.j;
/* loaded from: classes2.dex */
public class a<T> extends j<T> implements rx.b.a<T> {
    private final h<T> iFR;

    public a(h<T> hVar) {
        this.iFR = hVar;
    }

    public static <T> a<T> dF(long j) {
        h hVar = new h(j);
        a<T> aVar = new a<>(hVar);
        aVar.add(hVar);
        return aVar;
    }

    @Override // rx.j
    public void onStart() {
        this.iFR.onStart();
    }

    @Override // rx.e
    public void onCompleted() {
        this.iFR.onCompleted();
    }

    @Override // rx.j
    public void setProducer(f fVar) {
        this.iFR.setProducer(fVar);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iFR.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iFR.onNext(t);
    }

    public String toString() {
        return this.iFR.toString();
    }
}
