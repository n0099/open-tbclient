package rx.internal.a;

import rx.b.h;
import rx.f;
import rx.j;
/* loaded from: classes2.dex */
public class a<T> extends j<T> implements rx.b.a<T> {
    private final h<T> iur;

    public a(h<T> hVar) {
        this.iur = hVar;
    }

    public static <T> a<T> dt(long j) {
        h hVar = new h(j);
        a<T> aVar = new a<>(hVar);
        aVar.add(hVar);
        return aVar;
    }

    @Override // rx.j
    public void onStart() {
        this.iur.onStart();
    }

    @Override // rx.e
    public void onCompleted() {
        this.iur.onCompleted();
    }

    @Override // rx.j
    public void setProducer(f fVar) {
        this.iur.setProducer(fVar);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iur.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iur.onNext(t);
    }

    public String toString() {
        return this.iur.toString();
    }
}
