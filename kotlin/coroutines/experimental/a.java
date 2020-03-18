package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a implements d {
    private final d nDQ;
    private final d.b nDR;

    public a(d dVar, d.b bVar) {
        q.j(dVar, "left");
        q.j(bVar, "element");
        this.nDQ = dVar;
        this.nDR = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.nDR.a(cVar);
            if (e == null) {
                d dVar = aVar.nDQ;
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
        return mVar.invoke((Object) this.nDQ.fold(r, mVar), this.nDR);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        if (this.nDR.a(cVar) != null) {
            return this.nDQ;
        }
        d b = this.nDQ.b(cVar);
        return b == this.nDQ ? this : b == e.nDU ? this.nDR : new a(b, this.nDR);
    }

    private final int size() {
        if (this.nDQ instanceof a) {
            return ((a) this.nDQ).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.h(a((d.c<d.b>) bVar.dKP()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.nDR)) {
            d dVar = aVar.nDQ;
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
        return this.nDQ.hashCode() + this.nDR.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
