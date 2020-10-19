package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class a implements d {
    private final d oRr;
    private final d.b oRs;

    public a(d dVar, d.b bVar) {
        q.n(dVar, "left");
        q.n(bVar, "element");
        this.oRr = dVar;
        this.oRs = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.n(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.oRs.a(cVar);
            if (e == null) {
                d dVar = aVar.oRr;
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
    public <R> R fold(R r, m<? super R, ? super d.b, ? extends R> mVar) {
        q.n(mVar, "operation");
        return mVar.invoke((Object) this.oRr.fold(r, mVar), this.oRs);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.n(cVar, "key");
        if (this.oRs.a(cVar) != null) {
            return this.oRr;
        }
        d b = this.oRr.b(cVar);
        return b == this.oRr ? this : b == e.oRv ? this.oRs : new a(b, this.oRs);
    }

    private final int size() {
        if (this.oRr instanceof a) {
            return ((a) this.oRr).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.l(a((d.c<d.b>) bVar.enU()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.oRs)) {
            d dVar = aVar.oRr;
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
        return this.oRr.hashCode() + this.oRs.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
