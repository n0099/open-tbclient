package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class a implements d {
    private final d nBo;
    private final d.b nBp;

    public a(d dVar, d.b bVar) {
        q.j(dVar, "left");
        q.j(bVar, "element");
        this.nBo = dVar;
        this.nBp = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.nBp.a(cVar);
            if (e == null) {
                d dVar = aVar.nBo;
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
        return mVar.invoke((Object) this.nBo.fold(r, mVar), this.nBp);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        if (this.nBp.a(cVar) != null) {
            return this.nBo;
        }
        d b = this.nBo.b(cVar);
        return b == this.nBo ? this : b == e.nBs ? this.nBp : new a(b, this.nBp);
    }

    private final int size() {
        if (this.nBo instanceof a) {
            return ((a) this.nBo).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.h(a((d.c<d.b>) bVar.dJf()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.nBp)) {
            d dVar = aVar.nBo;
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
        return this.nBo.hashCode() + this.nBp.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
