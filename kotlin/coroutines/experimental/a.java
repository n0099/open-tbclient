package kotlin.coroutines.experimental;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d kvI;
    private final d.b kvJ;

    public a(d dVar, d.b bVar) {
        p.i(dVar, "left");
        p.i(bVar, "element");
        this.kvI = dVar;
        this.kvJ = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.i(cVar, TiebaInitialize.Params.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.kvJ.a(cVar);
            if (e == null) {
                d dVar = aVar.kvI;
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
        p.i(cVar, "operation");
        return cVar.invoke((Object) this.kvI.a(r, cVar), this.kvJ);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.i(cVar, TiebaInitialize.Params.KEY);
        if (this.kvJ.a(cVar) != null) {
            return this.kvI;
        }
        d b = this.kvI.b(cVar);
        return b == this.kvI ? this : b == e.kvM ? this.kvJ : new a(b, this.kvJ);
    }

    private final int size() {
        if (this.kvI instanceof a) {
            return ((a) this.kvI).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.f(a((d.c<d.b>) bVar.cMU()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.kvJ)) {
            d dVar = aVar.kvI;
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
        return this.kvI.hashCode() + this.kvJ.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
