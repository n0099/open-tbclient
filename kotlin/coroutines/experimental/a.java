package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class a implements d {
    private final d pIO;
    private final d.b pIP;

    public a(d dVar, d.b bVar) {
        q.n(dVar, "left");
        q.n(bVar, "element");
        this.pIO = dVar;
        this.pIP = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.n(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.pIP.a(cVar);
            if (e == null) {
                d dVar = aVar.pIO;
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
        return mVar.invoke((Object) this.pIO.fold(r, mVar), this.pIP);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.n(cVar, "key");
        if (this.pIP.a(cVar) != null) {
            return this.pIO;
        }
        d b = this.pIO.b(cVar);
        return b == this.pIO ? this : b == e.pIS ? this.pIP : new a(b, this.pIP);
    }

    private final int size() {
        if (this.pIO instanceof a) {
            return ((a) this.pIO).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.l(a((d.c<d.b>) bVar.exT()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.pIP)) {
            d dVar = aVar.pIO;
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
        return this.pIO.hashCode() + this.pIP.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
