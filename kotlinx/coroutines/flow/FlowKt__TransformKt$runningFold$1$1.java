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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.ObjectRef<R> $accumulator;
    public final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
    public final /* synthetic */ FlowCollector<R> $this_unsafeFlow;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$runningFold$1$1$emit$1 flowKt__TransformKt$runningFold$1$1$emit$1;
        Object coroutine_suspended;
        int i;
        FlowKt__TransformKt$runningFold$1$1<T> flowKt__TransformKt$runningFold$1$1;
        Ref.ObjectRef objectRef;
        FlowCollector<R> flowCollector;
        T t2;
        if (continuation instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) {
            flowKt__TransformKt$runningFold$1$1$emit$1 = (FlowKt__TransformKt$runningFold$1$1$emit$1) continuation;
            int i2 = flowKt__TransformKt$runningFold$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningFold$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                T t3 = (T) flowKt__TransformKt$runningFold$1$1$emit$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(t3);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) flowKt__TransformKt$runningFold$1$1$emit$1.L$1;
                    flowKt__TransformKt$runningFold$1$1 = (FlowKt__TransformKt$runningFold$1$1) flowKt__TransformKt$runningFold$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(t3);
                } else {
                    ResultKt.throwOnFailure(t3);
                    Ref.ObjectRef objectRef2 = this.$accumulator;
                    Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                    T t4 = objectRef2.element;
                    flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = this;
                    flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = objectRef2;
                    flowKt__TransformKt$runningFold$1$1$emit$1.label = 1;
                    Object invoke = function3.invoke(t4, t, flowKt__TransformKt$runningFold$1$1$emit$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningFold$1$1 = this;
                    t3 = (T) invoke;
                    objectRef = objectRef2;
                }
                objectRef.element = t3;
                flowCollector = flowKt__TransformKt$runningFold$1$1.$this_unsafeFlow;
                t2 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
                flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
                flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
                flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
                if (flowCollector.emit(t2, flowKt__TransformKt$runningFold$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, continuation);
        T t32 = (T) flowKt__TransformKt$runningFold$1$1$emit$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
        if (i == 0) {
        }
        objectRef.element = t32;
        flowCollector = flowKt__TransformKt$runningFold$1$1.$this_unsafeFlow;
        t2 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
        if (flowCollector.emit(t2, flowKt__TransformKt$runningFold$1$1$emit$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
