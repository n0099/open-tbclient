package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = MatroskaExtractor.ID_PIXEL_WIDTH)
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1<T> implements FlowCollector<T> {
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$collectWhile$collector$1(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$1;
        Object obj;
        int i;
        FlowKt__LimitKt$collectWhile$collector$1<T> flowKt__LimitKt$collectWhile$collector$1;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) continuation;
            int i2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$collector$1$emit$1.label = i2 - Integer.MIN_VALUE;
                obj = flowKt__LimitKt$collectWhile$collector$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LimitKt$collectWhile$collector$1$emit$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__LimitKt$collectWhile$collector$1 = (FlowKt__LimitKt$collectWhile$collector$1) flowKt__LimitKt$collectWhile$collector$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    flowKt__LimitKt$collectWhile$collector$1$emit$1.L$0 = this;
                    flowKt__LimitKt$collectWhile$collector$1$emit$1.label = 1;
                    obj = function2.invoke(t, flowKt__LimitKt$collectWhile$collector$1$emit$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__LimitKt$collectWhile$collector$1 = this;
                }
                if (!((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
                throw new AbortFlowException(flowKt__LimitKt$collectWhile$collector$1);
            }
        }
        flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        obj = flowKt__LimitKt$collectWhile$collector$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LimitKt$collectWhile$collector$1$emit$1.label;
        if (i == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    public Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        InlineMarker.mark(5);
        if (((Boolean) this.$predicate.invoke(t, continuation)).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new AbortFlowException(this);
    }
}
