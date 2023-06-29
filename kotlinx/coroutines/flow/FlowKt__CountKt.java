package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"count", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (FlowKt__CountKt$count$1) continuation;
            int i2 = flowKt__CountKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$1.label;
                if (i == 0) {
                    if (i == 1) {
                        intRef = (Ref.IntRef) flowKt__CountKt$count$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<? super Object> flowKt__CountKt$count$2 = new FlowKt__CountKt$count$2<>(intRef2);
                    flowKt__CountKt$count$1.L$0 = intRef2;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(flowKt__CountKt$count$2, flowKt__CountKt$count$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        Object obj2 = flowKt__CountKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$1.label;
        if (i == 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (FlowKt__CountKt$count$3) continuation;
            int i2 = flowKt__CountKt$count$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$3.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$3.label;
                if (i == 0) {
                    if (i == 1) {
                        intRef = (Ref.IntRef) flowKt__CountKt$count$3.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<? super Object> flowKt__CountKt$count$4 = new FlowKt__CountKt$count$4<>(function2, intRef2);
                    flowKt__CountKt$count$3.L$0 = intRef2;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(flowKt__CountKt$count$4, flowKt__CountKt$count$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        Object obj2 = flowKt__CountKt$count$3.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$3.label;
        if (i == 0) {
        }
        return Boxing.boxInt(intRef.element);
    }
}
