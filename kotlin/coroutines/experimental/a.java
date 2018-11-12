package kotlin.coroutines.experimental;

import com.baidu.fsg.base.armor.RimArmor;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d iqP;
    private final d.b iqQ;

    public a(d dVar, d.b bVar) {
        p.h((Object) dVar, "left");
        p.h((Object) bVar, "element");
        this.iqP = dVar;
        this.iqQ = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        a aVar = this;
        while (true) {
            E e = (E) aVar.iqQ.a(cVar);
            if (e == null) {
                d dVar = aVar.iqP;
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
        return cVar.invoke((Object) this.iqP.a(r, cVar), this.iqQ);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.h((Object) cVar, RimArmor.KEY);
        if (this.iqQ.a(cVar) != null) {
            return this.iqP;
        }
        d b = this.iqP.b(cVar);
        return b == this.iqP ? this : b == e.iqT ? this.iqQ : new a(b, this.iqQ);
    }

    private final int size() {
        if (this.iqP instanceof a) {
            return ((a) this.iqP).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.bZE()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.iqQ)) {
            d dVar = aVar.iqP;
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
        return this.iqP.hashCode() + this.iqQ.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
