package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a implements d {
    private final d mXp;
    private final d.b mXq;

    public a(d dVar, d.b bVar) {
        q.j(dVar, "left");
        q.j(bVar, "element");
        this.mXp = dVar;
        this.mXq = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.mXq.a(cVar);
            if (e == null) {
                d dVar = aVar.mXp;
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
        return mVar.invoke((Object) this.mXp.fold(r, mVar), this.mXq);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        if (this.mXq.a(cVar) != null) {
            return this.mXp;
        }
        d b = this.mXp.b(cVar);
        return b == this.mXp ? this : b == e.mXt ? this.mXq : new a(b, this.mXq);
    }

    private final int size() {
        if (this.mXp instanceof a) {
            return ((a) this.mXp).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.k(a((d.c<d.b>) bVar.dDO()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.mXq)) {
            d dVar = aVar.mXp;
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
        return this.mXp.hashCode() + this.mXq.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
