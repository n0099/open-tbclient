package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class a implements d {
    private final d pSi;
    private final d.b pSj;

    public a(d dVar, d.b bVar) {
        q.n(dVar, "left");
        q.n(bVar, "element");
        this.pSi = dVar;
        this.pSj = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.n(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.pSj.a(cVar);
            if (e == null) {
                d dVar = aVar.pSi;
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
        q.n(mVar, "operation");
        return mVar.invoke((Object) this.pSi.fold(r, mVar), this.pSj);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.n(cVar, "key");
        if (this.pSj.a(cVar) != null) {
            return this.pSi;
        }
        d b = this.pSi.b(cVar);
        return b == this.pSi ? this : b == e.pSm ? this.pSj : new a(b, this.pSj);
    }

    private final int size() {
        if (this.pSi instanceof a) {
            return ((a) this.pSi).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.l(a((d.c<d.b>) bVar.eBI()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.pSj)) {
            d dVar = aVar.pSi;
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
        return this.pSi.hashCode() + this.pSj.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
