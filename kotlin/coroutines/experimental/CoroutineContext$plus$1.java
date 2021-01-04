package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
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
        d b2 = dVar.b(bVar.eMd());
        if (b2 == e.qlU) {
            return bVar;
        }
        c cVar = (c) b2.a(c.qlS);
        if (cVar == null) {
            aVar = new a(b2, bVar);
        } else {
            d b3 = b2.b(c.qlS);
            aVar = b3 == e.qlU ? new a(bVar, cVar) : new a(new a(b3, bVar), cVar);
        }
        return aVar;
    }
}
