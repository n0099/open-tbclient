package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d iBj;
    private final d.b iBk;

    public a(d dVar, d.b bVar) {
        p.j(dVar, "left");
        p.j(bVar, "element");
        this.iBj = dVar;
        this.iBk = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.j(cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.iBk.a(cVar);
            if (e == null) {
                d dVar = aVar.iBj;
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
        return cVar.invoke((Object) this.iBj.a(r, cVar), this.iBk);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.j(cVar, RimArmor.KEY);
        if (this.iBk.a(cVar) != null) {
            return this.iBj;
        }
        d b = this.iBj.b(cVar);
        return b == this.iBj ? this : b == e.iBn ? this.iBk : new a(b, this.iBk);
    }

    private final int size() {
        if (this.iBj instanceof a) {
            return ((a) this.iBj).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.ccA()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.iBk)) {
            d dVar = aVar.iBj;
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
        return this.iBj.hashCode() + this.iBk.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
