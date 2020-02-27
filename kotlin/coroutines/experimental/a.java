package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a implements d {
    private final d nBQ;
    private final d.b nBR;

    public a(d dVar, d.b bVar) {
        q.j(dVar, "left");
        q.j(bVar, "element");
        this.nBQ = dVar;
        this.nBR = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.nBR.a(cVar);
            if (e == null) {
                d dVar = aVar.nBQ;
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
    public <R> R fold(R r, m<? super R, ? super d.b, ? extends R> mVar) {
        q.j(mVar, "operation");
        return mVar.invoke((Object) this.nBQ.fold(r, mVar), this.nBR);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        if (this.nBR.a(cVar) != null) {
            return this.nBQ;
        }
        d b = this.nBQ.b(cVar);
        return b == this.nBQ ? this : b == e.nBU ? this.nBR : new a(b, this.nBR);
    }

    private final int size() {
        if (this.nBQ instanceof a) {
            return ((a) this.nBQ).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.h(a((d.c<d.b>) bVar.dKm()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.nBR)) {
            d dVar = aVar.nBQ;
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
        return this.nBQ.hashCode() + this.nBR.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
