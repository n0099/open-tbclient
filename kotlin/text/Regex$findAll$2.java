package kotlin.text;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import kotlin.jvm.internal.FunctionReference;
@kotlin.h
/* loaded from: classes7.dex */
final class Regex$findAll$2 extends FunctionReference implements kotlin.jvm.a.b<i, i> {
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
        return kotlin.jvm.internal.t.M(i.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final i invoke(i iVar) {
        kotlin.jvm.internal.q.m(iVar, "p1");
        return iVar.dMi();
    }
}
