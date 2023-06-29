package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$reduce$2<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    public final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super S, ? super T, ? super kotlin.coroutines.Continuation<? super S>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
        this.$accumulator = objectRef;
        this.$operation = function3;
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: kotlin.jvm.functions.Function3<S, T, kotlin.coroutines.Continuation<? super S>, java.lang.Object>, kotlin.jvm.functions.Function3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Type inference failed for: r8v5 */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
        int i;
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
            flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
            int i2 = flowKt__ReduceKt$reduce$2$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$2$emit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$reduce$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$reduce$2$emit$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.$accumulator;
                    Object obj2 = objectRef.element;
                    if (obj2 != NullSurrogateKt.NULL) {
                        Function3 function3 = this.$operation;
                        flowKt__ReduceKt$reduce$2$emit$1.L$0 = objectRef;
                        flowKt__ReduceKt$reduce$2$emit$1.label = 1;
                        Object invoke = function3.invoke(obj2, t, flowKt__ReduceKt$reduce$2$emit$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = invoke;
                        objectRef2 = objectRef;
                    }
                    objectRef.element = t;
                    return Unit.INSTANCE;
                }
                T t2 = obj;
                objectRef = objectRef2;
                t = t2;
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
        flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
        Object obj3 = flowKt__ReduceKt$reduce$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$reduce$2$emit$1.label;
        if (i == 0) {
        }
        T t22 = obj3;
        objectRef = objectRef2;
        t = t22;
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
