package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class a implements d {
    private final d mYN;
    private final d.b mYO;

    public a(d dVar, d.b bVar) {
        p.j(dVar, "left");
        p.j(bVar, "element");
        this.mYN = dVar;
        this.mYO = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.mYO.a(cVar);
            if (e == null) {
                d dVar = aVar.mYN;
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
        p.j(cVar, "operation");
        return cVar.invoke((Object) this.mYN.a(r, cVar), this.mYO);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.j(cVar, "key");
        if (this.mYO.a(cVar) != null) {
            return this.mYN;
        }
        d b = this.mYN.b(cVar);
        return b == this.mYN ? this : b == e.mYR ? this.mYO : new a(b, this.mYO);
    }

    private final int size() {
        if (this.mYN instanceof a) {
            return ((a) this.mYN).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.dEM()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.mYO)) {
            d dVar = aVar.mYN;
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
        return this.mYN.hashCode() + this.mYO.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
