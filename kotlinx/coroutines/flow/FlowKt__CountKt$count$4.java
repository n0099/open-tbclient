package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__CountKt$count$4<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.IntRef $i;
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CountKt$count$4(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
        this.$predicate = function2;
        this.$i = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
        Object obj;
        int i;
        FlowKt__CountKt$count$4<T> flowKt__CountKt$count$4;
        if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
            flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
            int i2 = flowKt__CountKt$count$4$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$4$emit$1.label = i2 - Integer.MIN_VALUE;
                obj = flowKt__CountKt$count$4$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$4$emit$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__CountKt$count$4 = (FlowKt__CountKt$count$4) flowKt__CountKt$count$4$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    flowKt__CountKt$count$4$emit$1.L$0 = this;
                    flowKt__CountKt$count$4$emit$1.label = 1;
                    obj = function2.invoke(t, flowKt__CountKt$count$4$emit$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__CountKt$count$4 = this;
                }
                if (((Boolean) obj).booleanValue()) {
                    flowKt__CountKt$count$4.$i.element++;
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
        obj = flowKt__CountKt$count$4$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$4$emit$1.label;
        if (i == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return Unit.INSTANCE;
    }
}
