package h.o.a;

import rx.internal.producers.SingleProducer;
/* loaded from: classes7.dex */
public final class a0<T> extends h.i<T> {

    /* renamed from: f  reason: collision with root package name */
    public final h.j<? super T> f68710f;

    public a0(h.j<? super T> jVar) {
        this.f68710f = jVar;
    }

    @Override // h.i
    public void b(Throwable th) {
        this.f68710f.onError(th);
    }

    @Override // h.i
    public void c(T t) {
        this.f68710f.setProducer(new SingleProducer(this.f68710f, t));
    }
}
