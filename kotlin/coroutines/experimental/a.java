package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a implements d {
    private final d qtB;
    private final d.b qtC;

    public a(d dVar, d.b bVar) {
        p.o(dVar, "left");
        p.o(bVar, "element");
        this.qtB = dVar;
        this.qtC = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.o(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.qtC.a(cVar);
            if (e == null) {
                d dVar = aVar.qtB;
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
        return cVar.invoke((Object) this.qtB.a(r, cVar), this.qtC);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.o(cVar, "key");
        if (this.qtC.a(cVar) != null) {
            return this.qtB;
        }
        d b2 = this.qtB.b(cVar);
        return b2 == this.qtB ? this : b2 == e.qtF ? this.qtC : new a(b2, this.qtC);
    }

    private final int size() {
        if (this.qtB instanceof a) {
            return ((a) this.qtB).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.l(a((d.c<d.b>) bVar.eLp()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.qtC)) {
            d dVar = aVar.qtB;
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
        return this.qtB.hashCode() + this.qtC.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
