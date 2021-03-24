package kotlin.text;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "invoke"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final /* synthetic */ class Regex$findAll$2 extends FunctionReference implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    public Regex$findAll$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return UnitedSchemeConstants.UNITED_SCHEME_NEXT;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MatchResult.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final MatchResult invoke(MatchResult matchResult) {
        return matchResult.next();
    }
}
