package rx.internal.a;

import rx.b.h;
import rx.f;
import rx.j;
/* loaded from: classes2.dex */
public class a<T> extends j<T> implements rx.b.a<T> {
    private final h<T> isH;

    public a(h<T> hVar) {
        this.isH = hVar;
    }

    public static <T> a<T> dy(long j) {
        h hVar = new h(j);
        a<T> aVar = new a<>(hVar);
        aVar.add(hVar);
        return aVar;
    }

    @Override // rx.j
    public void onStart() {
        this.isH.onStart();
    }

    @Override // rx.e
    public void onCompleted() {
        this.isH.onCompleted();
    }

    @Override // rx.j
    public void setProducer(f fVar) {
        this.isH.setProducer(fVar);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.isH.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.isH.onNext(t);
    }

    public String toString() {
        return this.isH.toString();
    }
}
