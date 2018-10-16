package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d ipe;
    private final d.b ipf;

    public a(d dVar, d.b bVar) {
        p.i(dVar, "left");
        p.i(bVar, "element");
        this.ipe = dVar;
        this.ipf = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.i(cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.ipf.a(cVar);
            if (e == null) {
                d dVar = aVar.ipe;
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
        return cVar.invoke((Object) this.ipe.a(r, cVar), this.ipf);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.i(cVar, RimArmor.KEY);
        if (this.ipf.a(cVar) != null) {
            return this.ipe;
        }
        d b = this.ipe.b(cVar);
        return b == this.ipe ? this : b == e.ipi ? this.ipf : new a(b, this.ipf);
    }

    private final int size() {
        if (this.ipe instanceof a) {
            return ((a) this.ipe).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cah()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.ipf)) {
            d dVar = aVar.ipe;
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
        return this.ipe.hashCode() + this.ipf.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
