package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
final class CoroutineContext$plus$1 extends Lambda implements m<d, d.b, d> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.m
    public final d invoke(d dVar, d.b bVar) {
        a aVar;
        q.n(dVar, "acc");
        q.n(bVar, "element");
        d b = dVar.b(bVar.enU());
        if (b == e.oRv) {
            return bVar;
        }
        c cVar = (c) b.a(c.oRt);
        if (cVar == null) {
            aVar = new a(b, bVar);
        } else {
            d b2 = b.b(c.oRt);
            aVar = b2 == e.oRv ? new a(bVar, cVar) : new a(new a(b2, bVar), cVar);
        }
        return aVar;
    }
}
