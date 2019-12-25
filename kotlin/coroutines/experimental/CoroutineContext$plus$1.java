package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
final class CoroutineContext$plus$1 extends Lambda implements kotlin.jvm.a.c<d, d.b, d> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final d invoke(d dVar, d.b bVar) {
        a aVar;
        p.j(dVar, "acc");
        p.j(bVar, "element");
        d b = dVar.b(bVar.dEM());
        if (b == e.mYR) {
            return bVar;
        }
        c cVar = (c) b.a(c.mYP);
        if (cVar == null) {
            aVar = new a(b, bVar);
        } else {
            d b2 = b.b(c.mYP);
            aVar = b2 == e.mYR ? new a(bVar, cVar) : new a(new a(b2, bVar), cVar);
        }
        return aVar;
    }
}
