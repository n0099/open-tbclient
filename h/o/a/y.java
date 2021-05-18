package h.o.a;

import rx.internal.producers.SingleProducer;
/* loaded from: classes7.dex */
public final class y<T> extends h.i<T> {

    /* renamed from: f  reason: collision with root package name */
    public final h.j<? super T> f68531f;

    public y(h.j<? super T> jVar) {
        this.f68531f = jVar;
    }

    @Override // h.i
    public void b(Throwable th) {
        this.f68531f.onError(th);
    }

    @Override // h.i
    public void c(T t) {
        this.f68531f.setProducer(new SingleProducer(this.f68531f, t));
    }
}
