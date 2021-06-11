package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow<R> {
    public final /* synthetic */ Flow $flow$inlined;
    public final /* synthetic */ Flow $this_combine$inlined;
    public final /* synthetic */ Function3 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(Flow flow, Flow flow2, Function3 function3) {
        this.$this_combine$inlined = flow;
        this.$flow$inlined = flow2;
        this.$transform$inlined = function3;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object combineTransformInternal = CombineKt.combineTransformInternal(flowCollector, this.$this_combine$inlined, this.$flow$inlined, new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(null, this), continuation);
        return combineTransformInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? combineTransformInternal : Unit.INSTANCE;
    }
}
