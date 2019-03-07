package kotlin.coroutines.experimental;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d jSc;
    private final d.b jSd;

    public a(d dVar, d.b bVar) {
        p.k(dVar, CustomDialogData.POS_LEFT);
        p.k(bVar, "element");
        this.jSc = dVar;
        this.jSd = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.k(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.jSd.a(cVar);
            if (e == null) {
                d dVar = aVar.jSc;
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
        return cVar.invoke((Object) this.jSc.a(r, cVar), this.jSd);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.k(cVar, "key");
        if (this.jSd.a(cVar) != null) {
            return this.jSc;
        }
        d b = this.jSc.b(cVar);
        return b == this.jSc ? this : b == e.jSg ? this.jSd : new a(b, this.jSd);
    }

    private final int size() {
        if (this.jSc instanceof a) {
            return ((a) this.jSc).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cCn()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.jSd)) {
            d dVar = aVar.jSc;
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
        return this.jSc.hashCode() + this.jSd.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
