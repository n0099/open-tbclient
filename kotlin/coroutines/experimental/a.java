package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d iCq;
    private final d.b iCr;

    public a(d dVar, d.b bVar) {
        p.j(dVar, "left");
        p.j(bVar, "element");
        this.iCq = dVar;
        this.iCr = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.j(cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.iCr.a(cVar);
            if (e == null) {
                d dVar = aVar.iCq;
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
        p.j(cVar, "operation");
        return cVar.invoke((Object) this.iCq.a(r, cVar), this.iCr);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.j(cVar, RimArmor.KEY);
        if (this.iCr.a(cVar) != null) {
            return this.iCq;
        }
        d b = this.iCq.b(cVar);
        return b == this.iCq ? this : b == e.iCu ? this.iCr : new a(b, this.iCr);
    }

    private final int size() {
        if (this.iCq instanceof a) {
            return ((a) this.iCq).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cdi()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.iCr)) {
            d dVar = aVar.iCq;
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
        return this.iCq.hashCode() + this.iCr.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
