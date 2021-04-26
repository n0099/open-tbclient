package h.o.a;

import h.d;
import h.h;
/* loaded from: classes7.dex */
public final class a0<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67720e;

    public a0(h.d<T> dVar) {
        this.f67720e = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        y yVar = new y(jVar);
        jVar.add(yVar);
        this.f67720e.call(yVar);
    }
}
