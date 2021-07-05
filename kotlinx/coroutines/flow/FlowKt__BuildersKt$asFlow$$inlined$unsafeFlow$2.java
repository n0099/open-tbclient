package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 implements Flow<T> {
    public final /* synthetic */ Function1 $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {113, 113}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "this", "collector", "continuation", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1  reason: invalid class name */
    /* loaded from: classes10.dex */
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[RETURN] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Object coroutine_suspended;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        Continuation continuation2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = anonymousClass1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.$this_asFlow$inlined;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = anonymousClass1;
                    anonymousClass1.L$3 = flowCollector;
                    anonymousClass1.L$4 = flowCollector;
                    anonymousClass1.label = 1;
                    obj = function1.invoke(anonymousClass1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = this;
                    flowCollector2 = flowCollector;
                    flowCollector3 = flowCollector2;
                    continuation2 = anonymousClass1;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                    Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$1;
                    FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$22 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    flowCollector = (FlowCollector) anonymousClass1.L$4;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                    continuation2 = (Continuation) anonymousClass1.L$2;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                anonymousClass1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
                anonymousClass1.L$1 = flowCollector3;
                anonymousClass1.L$2 = continuation2;
                anonymousClass1.L$3 = flowCollector2;
                anonymousClass1.label = 2;
                if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        obj = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = anonymousClass1.label;
        if (i2 != 0) {
        }
        anonymousClass1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        anonymousClass1.L$1 = flowCollector3;
        anonymousClass1.L$2 = continuation2;
        anonymousClass1.L$3 = flowCollector2;
        anonymousClass1.label = 2;
        if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
