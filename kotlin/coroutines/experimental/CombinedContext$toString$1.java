package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
final class CombinedContext$toString$1 extends Lambda implements kotlin.jvm.a.c<String, d.b, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final String invoke(String str, d.b bVar) {
        p.p(str, "acc");
        p.p(bVar, "element");
        return str.length() == 0 ? bVar.toString() : str + ", " + bVar;
    }
}
