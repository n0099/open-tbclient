package kotlin.coroutines;

import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes20.dex */
final class CombinedContext$toString$1 extends Lambda implements m<String, c.b, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.m
    public final String invoke(String str, c.b bVar) {
        q.m(str, "acc");
        q.m(bVar, "element");
        return str.length() == 0 ? bVar.toString() : str + ", " + bVar;
    }
}
