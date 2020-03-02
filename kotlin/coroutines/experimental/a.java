package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a implements d {
    private final d nBS;
    private final d.b nBT;

    public a(d dVar, d.b bVar) {
        q.j(dVar, "left");
        q.j(bVar, "element");
        this.nBS = dVar;
        this.nBT = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.nBT.a(cVar);
            if (e == null) {
                d dVar = aVar.nBS;
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
        return mVar.invoke((Object) this.nBS.fold(r, mVar), this.nBT);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        if (this.nBT.a(cVar) != null) {
            return this.nBS;
        }
        d b = this.nBS.b(cVar);
        return b == this.nBS ? this : b == e.nBW ? this.nBT : new a(b, this.nBT);
    }

    private final int size() {
        if (this.nBS instanceof a) {
            return ((a) this.nBS).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.h(a((d.c<d.b>) bVar.dKo()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.nBT)) {
            d dVar = aVar.nBS;
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
        return this.nBS.hashCode() + this.nBT.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
