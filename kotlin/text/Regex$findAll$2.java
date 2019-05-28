package kotlin.text;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import kotlin.jvm.internal.FunctionReference;
/* loaded from: classes2.dex */
final class Regex$findAll$2 extends FunctionReference implements kotlin.jvm.a.b<h, h> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return UnitedSchemeConstants.UNITED_SCHEME_NEXT;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final kotlin.reflect.d getOwner() {
        return kotlin.jvm.internal.s.D(h.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final h invoke(h hVar) {
        kotlin.jvm.internal.p.k(hVar, "p1");
        return hVar.cKn();
    }
}
