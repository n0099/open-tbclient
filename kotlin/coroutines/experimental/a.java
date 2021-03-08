package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
public final class a implements d {
    private final d qud;
    private final d.b que;

    public a(d dVar, d.b bVar) {
        p.p(dVar, "left");
        p.p(bVar, "element");
        this.qud = dVar;
        this.que = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.p(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.que.a(cVar);
            if (e == null) {
                d dVar = aVar.qud;
                if (dVar instanceof a) {
                    aVar = (a) dVar;
                } else {
                    return (E) dVar.a(cVar);
                }
            } else {
                return e;
            }
        }
    }

    @Override // kotlin.coroutines.experimental.d
    public <R> R a(R r, kotlin.jvm.a.c<? super R, ? super d.b, ? extends R> cVar) {
        p.p(cVar, "operation");
        return cVar.invoke((Object) this.qud.a(r, cVar), this.que);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.p(cVar, "key");
        if (this.que.a(cVar) != null) {
            return this.qud;
        }
        d b = this.qud.b(cVar);
        return b == this.qud ? this : b == e.quh ? this.que : new a(b, this.que);
    }

    private final int size() {
        if (this.qud instanceof a) {
            return ((a) this.qud).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.l(a((d.c<d.b>) bVar.eKX()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.que)) {
            d dVar = aVar.qud;
            if (dVar instanceof a) {
                aVar = (a) dVar;
            } else if (dVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
            } else {
                return a((d.b) dVar);
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof a) && ((a) obj).size() == size() && ((a) obj).a(this));
    }

    public int hashCode() {
        return this.qud.hashCode() + this.que.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
