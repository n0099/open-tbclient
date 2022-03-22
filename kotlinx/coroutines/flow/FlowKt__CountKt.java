package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "count", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @ExperimentalCoroutinesApi
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
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    FlowCollector<T> flowCollector = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(Object obj2, Continuation continuation2) {
                            Ref.IntRef.this.element++;
                            return Unit.INSTANCE;
                        }
                    };
                    flowKt__CountKt$count$1.L$0 = flow;
                    flowKt__CountKt$count$1.L$1 = intRef2;
                    flowKt__CountKt$count$1.L$2 = flow;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(flowCollector, flowKt__CountKt$count$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Flow flow2 = (Flow) flowKt__CountKt$count$1.L$2;
                    intRef = (Ref.IntRef) flowKt__CountKt$count$1.L$1;
                    Flow flow3 = (Flow) flowKt__CountKt$count$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        Object obj2 = flowKt__CountKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$1.label;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @ExperimentalCoroutinesApi
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
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    FlowCollector<? super Object> flowKt__CountKt$count$$inlined$collect$2 = new FlowKt__CountKt$count$$inlined$collect$2(function2, intRef2);
                    flowKt__CountKt$count$3.L$0 = flow;
                    flowKt__CountKt$count$3.L$1 = function2;
                    flowKt__CountKt$count$3.L$2 = intRef2;
                    flowKt__CountKt$count$3.L$3 = flow;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(flowKt__CountKt$count$$inlined$collect$2, flowKt__CountKt$count$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Flow flow2 = (Flow) flowKt__CountKt$count$3.L$3;
                    intRef = (Ref.IntRef) flowKt__CountKt$count$3.L$2;
                    Function2 function22 = (Function2) flowKt__CountKt$count$3.L$1;
                    Flow flow3 = (Flow) flowKt__CountKt$count$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        Object obj2 = flowKt__CountKt$count$3.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$3.label;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }
}
