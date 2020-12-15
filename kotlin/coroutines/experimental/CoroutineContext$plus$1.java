package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes17.dex */
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
        d b = dVar.b(bVar.eDV());
        if (b == e.pKr) {
            return bVar;
        }
        c cVar = (c) b.a(c.pKp);
        if (cVar == null) {
            aVar = new a(b, bVar);
        } else {
            d b2 = b.b(c.pKp);
            aVar = b2 == e.pKr ? new a(bVar, cVar) : new a(new a(b2, bVar), cVar);
        }
        return aVar;
    }
}
