package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 implements Flow<T> {
    public final /* synthetic */ Iterator $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(Iterator it) {
        this.$this_asFlow$inlined = it;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlin.coroutines.Continuation] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4;
        Iterator it;
        AnonymousClass1 anonymousClass12;
        Object obj;
        AnonymousClass1 anonymousClass13;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        Iterator it2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = anonymousClass1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 = this;
                    it = this.$this_asFlow$inlined;
                    anonymousClass12 = anonymousClass1;
                    obj = coroutine_suspended;
                    anonymousClass13 = anonymousClass12;
                    flowCollector2 = flowCollector;
                    flowCollector3 = flowCollector2;
                    it2 = it;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj3 = anonymousClass1.L$7;
                    Object obj4 = anonymousClass1.L$6;
                    it2 = (Iterator) anonymousClass1.L$5;
                    ?? r5 = (Continuation) anonymousClass1.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                    obj = coroutine_suspended;
                    anonymousClass13 = anonymousClass1;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                    it = (Iterator) anonymousClass1.L$4;
                    anonymousClass12 = r5;
                }
                while (it2.hasNext()) {
                    Object next = it2.next();
                    anonymousClass13.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4;
                    anonymousClass13.L$1 = flowCollector3;
                    anonymousClass13.L$2 = anonymousClass12;
                    anonymousClass13.L$3 = flowCollector2;
                    anonymousClass13.L$4 = it;
                    anonymousClass13.L$5 = it2;
                    anonymousClass13.L$6 = next;
                    anonymousClass13.L$7 = next;
                    anonymousClass13.label = 1;
                    if (flowCollector2.emit(next, anonymousClass13) == obj) {
                        return obj;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = anonymousClass1.label;
        if (i2 != 0) {
        }
        while (it2.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
