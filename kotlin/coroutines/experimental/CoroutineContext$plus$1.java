package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
final class CoroutineContext$plus$1 extends Lambda implements kotlin.jvm.a.c<d, d.b, d> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final d invoke(d dVar, d.b bVar) {
        a aVar;
        p.o(dVar, "acc");
        p.o(bVar, "element");
        d b2 = dVar.b(bVar.eLp());
        if (b2 == e.qtF) {
            return bVar;
        }
        c cVar = (c) b2.a(c.qtD);
        if (cVar == null) {
            aVar = new a(b2, bVar);
        } else {
            d b3 = b2.b(c.qtD);
            aVar = b3 == e.qtF ? new a(bVar, cVar) : new a(new a(b3, bVar), cVar);
        }
        return aVar;
    }
}
