package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "e", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    public final /* synthetic */ Function1 $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(Function1 function1) {
        super(1);
        this.$block = function1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Throwable invoke(Throwable th) {
        Object m713constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m713constructorimpl = Result.m713constructorimpl((Throwable) this.$block.invoke(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            m713constructorimpl = Result.m713constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m719isFailureimpl(m713constructorimpl)) {
            m713constructorimpl = null;
        }
        return (Throwable) m713constructorimpl;
    }
}
