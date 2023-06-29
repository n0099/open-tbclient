package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$withIndex$1$1<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.IntRef $index;
    public final /* synthetic */ FlowCollector<IndexedValue<? extends T>> $this_unsafeFlow;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super kotlin.collections.IndexedValue<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$withIndex$1$1(FlowCollector<? super IndexedValue<? extends T>> flowCollector, Ref.IntRef intRef) {
        this.$this_unsafeFlow = flowCollector;
        this.$index = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$withIndex$1$1$emit$1 flowKt__TransformKt$withIndex$1$1$emit$1;
        int i;
        if (continuation instanceof FlowKt__TransformKt$withIndex$1$1$emit$1) {
            flowKt__TransformKt$withIndex$1$1$emit$1 = (FlowKt__TransformKt$withIndex$1$1$emit$1) continuation;
            int i2 = flowKt__TransformKt$withIndex$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$withIndex$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__TransformKt$withIndex$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__TransformKt$withIndex$1$1$emit$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<IndexedValue<? extends T>> flowCollector = this.$this_unsafeFlow;
                    Ref.IntRef intRef = this.$index;
                    int i3 = intRef.element;
                    intRef.element = i3 + 1;
                    if (i3 >= 0) {
                        IndexedValue<? extends T> indexedValue = new IndexedValue<>(i3, t);
                        flowKt__TransformKt$withIndex$1$1$emit$1.label = 1;
                        if (flowCollector.emit(indexedValue, flowKt__TransformKt$withIndex$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new ArithmeticException("Index overflow has happened");
                    }
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__TransformKt$withIndex$1$1$emit$1 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, continuation);
        Object obj2 = flowKt__TransformKt$withIndex$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__TransformKt$withIndex$1$1$emit$1.label;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
