package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 implements FlowCollector<T> {
    public final /* synthetic */ Ref.ObjectRef $accumulator$inlined;
    public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    public final /* synthetic */ FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\b"}, d2 = {"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Ref.ObjectRef objectRef, FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1 flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.$accumulator$inlined = objectRef;
        this.this$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r9v16, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r9v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r9v8, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[RETURN] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i2;
        Ref.ObjectRef objectRef;
        FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
        Object obj2;
        Continuation continuation2;
        T t;
        Object obj3;
        FlowCollector flowCollector;
        T t2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                Object obj4 = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = anonymousClass1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj4);
                    objectRef = this.$accumulator$inlined;
                    T t3 = objectRef.element;
                    if (t3 == NullSurrogateKt.NULL) {
                        flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = this;
                        obj3 = obj;
                        obj2 = obj3;
                        continuation2 = anonymousClass1;
                        t = obj;
                    } else {
                        Function3 function3 = this.this$0.$operation$inlined;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = anonymousClass1;
                        anonymousClass1.L$3 = obj;
                        anonymousClass1.L$4 = objectRef;
                        anonymousClass1.label = 1;
                        Object invoke = function3.invoke(t3, obj, anonymousClass1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = this;
                        obj2 = obj;
                        continuation2 = anonymousClass1;
                        t = invoke;
                        obj3 = obj2;
                    }
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj5 = anonymousClass1.L$3;
                    Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                    Object obj6 = anonymousClass1.L$1;
                    FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$12 = (FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    return Unit.INSTANCE;
                } else {
                    obj3 = anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    obj2 = anonymousClass1.L$1;
                    flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1 = (FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    objectRef = (Ref.ObjectRef) anonymousClass1.L$4;
                    t = obj4;
                }
                objectRef.element = t;
                flowCollector = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
                t2 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$accumulator$inlined.element;
                anonymousClass1.L$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
                anonymousClass1.L$1 = obj2;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = obj3;
                anonymousClass1.label = 2;
                if (flowCollector.emit(t2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj42 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = anonymousClass1.label;
        if (i2 != 0) {
        }
        objectRef.element = t;
        flowCollector = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
        t2 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1.$accumulator$inlined.element;
        anonymousClass1.L$0 = flowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1;
        anonymousClass1.L$1 = obj2;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = obj3;
        anonymousClass1.label = 2;
        if (flowCollector.emit(t2, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
