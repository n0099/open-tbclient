package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt__LimitKt$drop$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ int $count$inlined;
    public final /* synthetic */ Flow $this_drop$inlined;

    public FlowKt__LimitKt$drop$$inlined$unsafeFlow$1(Flow flow, int i2) {
        this.$this_drop$inlined = flow;
        this.$count$inlined = i2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        Object collect = this.$this_drop$inlined.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1$lambda$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation2) {
                Ref.IntRef intRef2 = intRef;
                int i2 = intRef2.element;
                if (i2 >= this.$count$inlined) {
                    Object emit = FlowCollector.this.emit(obj, continuation2);
                    if (emit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return emit;
                    }
                } else {
                    intRef2.element = i2 + 1;
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
