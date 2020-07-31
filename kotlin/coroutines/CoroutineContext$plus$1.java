package kotlin.coroutines;

import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes7.dex */
public final class CoroutineContext$plus$1 extends Lambda implements m<c, c.b, c> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.m
    public final c invoke(c cVar, c.b bVar) {
        CombinedContext combinedContext;
        q.m(cVar, "acc");
        q.m(bVar, "element");
        c minusKey = cVar.minusKey(bVar.dTY());
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return bVar;
        }
        b bVar2 = (b) minusKey.get(b.nYb);
        if (bVar2 == null) {
            combinedContext = new CombinedContext(minusKey, bVar);
        } else {
            c minusKey2 = minusKey.minusKey(b.nYb);
            combinedContext = minusKey2 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(bVar, bVar2) : new CombinedContext(new CombinedContext(minusKey2, bVar), bVar2);
        }
        return combinedContext;
    }
}
