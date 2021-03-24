package h.o.a;

import h.d;
/* loaded from: classes7.dex */
public final class h<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f67735e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b<? extends R, ? super T> f67736f;

    public h(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.f67735e = aVar;
        this.f67736f = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        try {
            h.j<? super T> call = h.r.c.n(this.f67736f).call(jVar);
            call.onStart();
            this.f67735e.call(call);
        } catch (Throwable th) {
            h.m.a.e(th);
            jVar.onError(th);
        }
    }
}
