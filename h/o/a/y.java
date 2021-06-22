package h.o.a;

import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class y<T> extends h.i<T> {

    /* renamed from: f  reason: collision with root package name */
    public final h.j<? super T> f71934f;

    public y(h.j<? super T> jVar) {
        this.f71934f = jVar;
    }

    @Override // h.i
    public void b(Throwable th) {
        this.f71934f.onError(th);
    }

    @Override // h.i
    public void c(T t) {
        this.f71934f.setProducer(new SingleProducer(this.f71934f, t));
    }
}
