package h.o.a;

import h.d;
import h.h;
/* loaded from: classes8.dex */
public final class a0<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71699e;

    public a0(h.c<T> cVar) {
        this.f71699e = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        y yVar = new y(jVar);
        jVar.add(yVar);
        this.f71699e.call(yVar);
    }
}
