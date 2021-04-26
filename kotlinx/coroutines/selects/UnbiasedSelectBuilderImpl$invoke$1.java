package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UnbiasedSelectBuilderImpl$invoke$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ SelectClause0 $this_invoke;
    public final /* synthetic */ UnbiasedSelectBuilderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$invoke$1(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl, SelectClause0 selectClause0, Function1 function1) {
        super(0);
        this.this$0 = unbiasedSelectBuilderImpl;
        this.$this_invoke = selectClause0;
        this.$block = function1;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_invoke.registerSelectClause0(this.this$0.getInstance(), this.$block);
    }
}
