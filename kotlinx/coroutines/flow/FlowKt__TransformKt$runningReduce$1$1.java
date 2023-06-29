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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    public final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    public final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super T, ? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super T>, java.lang.Object>, kotlin.jvm.functions.Function3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef<Object> objectRef;
        FlowKt__TransformKt$runningReduce$1$1<T> flowKt__TransformKt$runningReduce$1$1;
        Ref.ObjectRef<Object> objectRef2;
        FlowCollector<T> flowCollector;
        T t2;
        if (continuation instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) continuation;
            int i2 = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef2 = (Ref.ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$1.L$1;
                    flowKt__TransformKt$runningReduce$1$1 = (FlowKt__TransformKt$runningReduce$1$1) flowKt__TransformKt$runningReduce$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.$accumulator;
                    Object obj2 = objectRef.element;
                    if (obj2 == NullSurrogateKt.NULL) {
                        flowKt__TransformKt$runningReduce$1$1 = this;
                        objectRef.element = t;
                        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
                        t2 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
                        if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = this;
                    flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = objectRef;
                    flowKt__TransformKt$runningReduce$1$1$emit$1.label = 1;
                    Object invoke = ((Function3<T, T, Continuation<? super T>, Object>) this.$operation).invoke(obj2, t, flowKt__TransformKt$runningReduce$1$1$emit$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningReduce$1$1 = this;
                    obj = invoke;
                    objectRef2 = objectRef;
                }
                T t3 = obj;
                objectRef = objectRef2;
                t = t3;
                objectRef.element = t;
                flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
                t2 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
                if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
        Object obj3 = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
        if (i == 0) {
        }
        T t32 = obj3;
        objectRef = objectRef2;
        t = t32;
        objectRef.element = t;
        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
        t2 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
        if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
