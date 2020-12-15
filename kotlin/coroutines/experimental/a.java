package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes17.dex */
public final class a implements d {
    private final d pKn;
    private final d.b pKo;

    public a(d dVar, d.b bVar) {
        p.o(dVar, "left");
        p.o(bVar, "element");
        this.pKn = dVar;
        this.pKo = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.o(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.pKo.a(cVar);
            if (e == null) {
                d dVar = aVar.pKn;
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
        p.o(cVar, "operation");
        return cVar.invoke((Object) this.pKn.a(r, cVar), this.pKo);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.o(cVar, "key");
        if (this.pKo.a(cVar) != null) {
            return this.pKn;
        }
        d b = this.pKn.b(cVar);
        return b == this.pKn ? this : b == e.pKr ? this.pKo : new a(b, this.pKo);
    }

    private final int size() {
        if (this.pKn instanceof a) {
            return ((a) this.pKn).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.l(a((d.c<d.b>) bVar.eDV()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.pKo)) {
            d dVar = aVar.pKn;
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
        return this.pKn.hashCode() + this.pKo.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
