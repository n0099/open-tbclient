package h.o.a;

import h.d;
/* loaded from: classes7.dex */
public final class h<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f68747e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b<? extends R, ? super T> f68748f;

    public h(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.f68747e = aVar;
        this.f68748f = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        try {
            h.j<? super T> call = h.r.c.n(this.f68748f).call(jVar);
            call.onStart();
            this.f68747e.call(call);
        } catch (Throwable th) {
            h.m.a.e(th);
            jVar.onError(th);
        }
    }
}
