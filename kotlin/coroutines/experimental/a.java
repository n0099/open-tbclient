package kotlin.coroutines.experimental;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d krB;
    private final d.b krC;

    public a(d dVar, d.b bVar) {
        p.k(dVar, CustomDialogData.POS_LEFT);
        p.k(bVar, "element");
        this.krB = dVar;
        this.krC = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.k(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.krC.a(cVar);
            if (e == null) {
                d dVar = aVar.krB;
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
        p.k(cVar, "operation");
        return cVar.invoke((Object) this.krB.a(r, cVar), this.krC);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.k(cVar, "key");
        if (this.krC.a(cVar) != null) {
            return this.krB;
        }
        d b = this.krB.b(cVar);
        return b == this.krB ? this : b == e.krF ? this.krC : new a(b, this.krC);
    }

    private final int size() {
        if (this.krB instanceof a) {
            return ((a) this.krB).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cNG()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.krC)) {
            d dVar = aVar.krB;
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
        return this.krB.hashCode() + this.krC.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
