package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d ixZ;
    private final d.b iya;

    public a(d dVar, d.b bVar) {
        p.h((Object) dVar, "left");
        p.h((Object) bVar, "element");
        this.ixZ = dVar;
        this.iya = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.iya.a(cVar);
            if (e == null) {
                d dVar = aVar.ixZ;
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
        p.h((Object) cVar, "operation");
        return cVar.invoke((Object) this.ixZ.a(r, cVar), this.iya);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        if (this.iya.a(cVar) != null) {
            return this.ixZ;
        }
        d b = this.ixZ.b(cVar);
        return b == this.ixZ ? this : b == e.iyd ? this.iya : new a(b, this.iya);
    }

    private final int size() {
        if (this.ixZ instanceof a) {
            return ((a) this.ixZ).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cbJ()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.iya)) {
            d dVar = aVar.ixZ;
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
        return this.ixZ.hashCode() + this.iya.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
