package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d ipf;
    private final d.b ipg;

    public a(d dVar, d.b bVar) {
        p.i(dVar, "left");
        p.i(bVar, "element");
        this.ipf = dVar;
        this.ipg = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.i(cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.ipg.a(cVar);
            if (e == null) {
                d dVar = aVar.ipf;
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
        return cVar.invoke((Object) this.ipf.a(r, cVar), this.ipg);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.i(cVar, RimArmor.KEY);
        if (this.ipg.a(cVar) != null) {
            return this.ipf;
        }
        d b = this.ipf.b(cVar);
        return b == this.ipf ? this : b == e.ipj ? this.ipg : new a(b, this.ipg);
    }

    private final int size() {
        if (this.ipf instanceof a) {
            return ((a) this.ipf).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cah()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.ipg)) {
            d dVar = aVar.ipf;
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
        return this.ipf.hashCode() + this.ipg.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
