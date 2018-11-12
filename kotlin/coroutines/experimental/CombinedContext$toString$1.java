package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class CombinedContext$toString$1 extends Lambda implements kotlin.jvm.a.c<String, d.b, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final String invoke(String str, d.b bVar) {
        p.h((Object) str, "acc");
        p.h((Object) bVar, "element");
        return str.length() == 0 ? bVar.toString() : str + ", " + bVar;
    }
}
