package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
final class CoroutineContext$plus$1 extends Lambda implements kotlin.jvm.a.c<d, d.b, d> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final d invoke(d dVar, d.b bVar) {
        a aVar;
        p.p(dVar, "acc");
        p.p(bVar, "element");
        d b = dVar.b(bVar.eKX());
        if (b == e.quh) {
            return bVar;
        }
        c cVar = (c) b.a(c.quf);
        if (cVar == null) {
            aVar = new a(b, bVar);
        } else {
            d b2 = b.b(c.quf);
            aVar = b2 == e.quh ? new a(bVar, cVar) : new a(new a(b2, bVar), cVar);
        }
        return aVar;
    }
}
