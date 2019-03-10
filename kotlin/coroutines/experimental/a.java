package kotlin.coroutines.experimental;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a implements d {
    private final d jSv;
    private final d.b jSw;

    public a(d dVar, d.b bVar) {
        p.k(dVar, CustomDialogData.POS_LEFT);
        p.k(bVar, "element");
        this.jSv = dVar;
        this.jSw = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        p.k(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.jSw.a(cVar);
            if (e == null) {
                d dVar = aVar.jSv;
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
        return cVar.invoke((Object) this.jSv.a(r, cVar), this.jSw);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        p.k(cVar, "key");
        if (this.jSw.a(cVar) != null) {
            return this.jSv;
        }
        d b = this.jSv.b(cVar);
        return b == this.jSv ? this : b == e.jSz ? this.jSw : new a(b, this.jSw);
    }

    private final int size() {
        if (this.jSv instanceof a) {
            return ((a) this.jSv).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return p.h(a((d.c<d.b>) bVar.cCx()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.jSw)) {
            d dVar = aVar.jSv;
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
        return this.jSv.hashCode() + this.jSw.hashCode();
    }

    public String toString() {
        return "[" + ((String) a("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
