package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DistinctFlowImpl$collect$2<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ FlowCollector<T> $collector;
    public final /* synthetic */ Ref.ObjectRef<Object> $previousKey;
    public final /* synthetic */ DistinctFlowImpl<T> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector) {
        this.this$0 = distinctFlowImpl;
        this.$previousKey = objectRef;
        this.$collector = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        int i;
        if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
            distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
            int i2 = distinctFlowImpl$collect$2$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                distinctFlowImpl$collect$2$emit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = distinctFlowImpl$collect$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = distinctFlowImpl$collect$2$emit$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    T t2 = (T) this.this$0.keySelector.invoke(t);
                    Object obj2 = this.$previousKey.element;
                    if (obj2 != NullSurrogateKt.NULL && this.this$0.areEquivalent.invoke(obj2, t2).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.$previousKey.element = t2;
                    FlowCollector<T> flowCollector = this.$collector;
                    distinctFlowImpl$collect$2$emit$1.label = 1;
                    if (flowCollector.emit(t, distinctFlowImpl$collect$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
        Object obj3 = distinctFlowImpl$collect$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = distinctFlowImpl$collect$2$emit$1.label;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
