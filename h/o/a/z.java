package h.o.a;

import rx.internal.producers.SingleProducer;
/* loaded from: classes7.dex */
public final class z<T> extends h.i<T> {

    /* renamed from: f  reason: collision with root package name */
    public final h.j<? super T> f67842f;

    public z(h.j<? super T> jVar) {
        this.f67842f = jVar;
    }

    @Override // h.i
    public void b(Throwable th) {
        this.f67842f.onError(th);
    }

    @Override // h.i
    public void c(T t) {
        this.f67842f.setProducer(new SingleProducer(this.f67842f, t));
    }
}
