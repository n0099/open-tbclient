package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.IntRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 implements Flow<Integer> {
    public final /* synthetic */ IntRange $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(IntRange intRange) {
        this.$this_asFlow$inlined = intRange;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9;
        Object obj;
        Object obj2;
        FlowCollector<? super Integer> flowCollector2;
        AnonymousClass1 anonymousClass12;
        Iterator<Integer> it;
        FlowCollector<? super Integer> flowCollector3;
        Object obj3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                Object obj4 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = anonymousClass1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj4);
                    IntRange intRange = this.$this_asFlow$inlined;
                    Iterator<Integer> it2 = intRange.iterator();
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 = this;
                    obj = intRange;
                    obj2 = coroutine_suspended;
                    flowCollector2 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    it = it2;
                    flowCollector3 = flowCollector2;
                    obj3 = anonymousClass12;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = anonymousClass1.I$0;
                    Object obj5 = anonymousClass1.L$6;
                    it = (Iterator) anonymousClass1.L$5;
                    Object obj6 = (Continuation) anonymousClass1.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                    obj = (Iterable) anonymousClass1.L$4;
                    obj3 = obj6;
                }
                while (it.hasNext()) {
                    Integer next = it.next();
                    int intValue = next.intValue();
                    Integer boxInt = Boxing.boxInt(intValue);
                    anonymousClass12.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9;
                    anonymousClass12.L$1 = flowCollector3;
                    anonymousClass12.L$2 = obj3;
                    anonymousClass12.L$3 = flowCollector2;
                    anonymousClass12.L$4 = obj;
                    anonymousClass12.L$5 = it;
                    anonymousClass12.L$6 = next;
                    anonymousClass12.I$0 = intValue;
                    anonymousClass12.label = 1;
                    if (flowCollector2.emit(boxInt, anonymousClass12) == obj2) {
                        return obj2;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj42 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = anonymousClass1.label;
        if (i2 != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
