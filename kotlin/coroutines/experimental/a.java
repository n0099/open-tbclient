package kotlin.coroutines.experimental;

import kotlin.TypeCastException;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes20.dex */
public final class a implements d {
    private final d osd;
    private final d.b ose;

    public a(d dVar, d.b bVar) {
        q.m(dVar, "left");
        q.m(bVar, "element");
        this.osd = dVar;
        this.ose = bVar;
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.m(cVar, "key");
        a aVar = this;
        while (true) {
            E e = (E) aVar.ose.a(cVar);
            if (e == null) {
                d dVar = aVar.osd;
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
        q.m(mVar, "operation");
        return mVar.invoke((Object) this.osd.fold(r, mVar), this.ose);
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.m(cVar, "key");
        if (this.ose.a(cVar) != null) {
            return this.osd;
        }
        d b = this.osd.b(cVar);
        return b == this.osd ? this : b == e.osh ? this.ose : new a(b, this.ose);
    }

    private final int size() {
        if (this.osd instanceof a) {
            return ((a) this.osd).size() + 1;
        }
        return 2;
    }

    private final boolean a(d.b bVar) {
        return q.l(a((d.c<d.b>) bVar.egc()), bVar);
    }

    private final boolean a(a aVar) {
        while (a(aVar.ose)) {
            d dVar = aVar.osd;
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
        return this.osd.hashCode() + this.ose.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }
}
