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
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector, SuspendFunction {
    public final /* synthetic */ Ref.BooleanRef $matched;
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    public final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$matched = booleanRef;
        this.$this_unsafeFlow = flowCollector;
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        int i;
        FlowKt__LimitKt$dropWhile$1$1<T> flowKt__LimitKt$dropWhile$1$1;
        if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
            flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
            int i2 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$dropWhile$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            t = (T) flowKt__LimitKt$dropWhile$1$1$emit$1.L$1;
                            flowKt__LimitKt$dropWhile$1$1 = (FlowKt__LimitKt$dropWhile$1$1) flowKt__LimitKt$dropWhile$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                flowKt__LimitKt$dropWhile$1$1.$matched.element = true;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = null;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                                if (flowKt__LimitKt$dropWhile$1$1.$this_unsafeFlow.emit(t, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (this.$matched.element) {
                        FlowCollector<T> flowCollector = this.$this_unsafeFlow;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 1;
                        if (flowCollector.emit(t, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = this;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = t;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.label = 2;
                    obj = function2.invoke(t, flowKt__LimitKt$dropWhile$1$1$emit$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__LimitKt$dropWhile$1$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
        Object obj2 = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
