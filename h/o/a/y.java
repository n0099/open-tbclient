package h.o.a;

import rx.internal.producers.SingleProducer;
/* loaded from: classes7.dex */
public final class y<T> extends h.i<T> {

    /* renamed from: f  reason: collision with root package name */
    public final h.j<? super T> f68574f;

    public y(h.j<? super T> jVar) {
        this.f68574f = jVar;
    }

    @Override // h.i
    public void b(Throwable th) {
        this.f68574f.onError(th);
    }

    @Override // h.i
    public void c(T t) {
        this.f68574f.setProducer(new SingleProducer(this.f68574f, t));
    }
}
