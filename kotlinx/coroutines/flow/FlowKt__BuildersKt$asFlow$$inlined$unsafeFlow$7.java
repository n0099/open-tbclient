package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 implements Flow<Integer> {
    public final /* synthetic */ int[] $this_asFlow$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", ExifInterface.GPS_DIRECTION_TRUE, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$2", "I$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$3;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(int[] iArr) {
        this.$this_asFlow$inlined = iArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0095 -> B:19:0x0098). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7;
        int[] iArr;
        int[] iArr2;
        Object obj;
        int length;
        AnonymousClass1 anonymousClass12;
        Object obj2;
        FlowCollector<? super Integer> flowCollector2;
        int i2;
        FlowCollector<? super Integer> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i4 = anonymousClass1.I$3;
                        int i5 = anonymousClass1.I$2;
                        i2 = anonymousClass1.I$1;
                        int i6 = anonymousClass1.I$0;
                        int[] iArr3 = (int[]) anonymousClass1.L$4;
                        flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        FlowCollector<? super Integer> flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                        iArr = (int[]) anonymousClass1.L$5;
                        obj = coroutine_suspended;
                        anonymousClass12 = anonymousClass1;
                        flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                        length = i6;
                        obj2 = (Continuation) anonymousClass1.L$2;
                        iArr2 = iArr3;
                        i2++;
                        flowCollector3 = flowCollector4;
                        if (i2 < length) {
                            int i7 = iArr[i2];
                            int intValue = Boxing.boxInt(i7).intValue();
                            Integer boxInt = Boxing.boxInt(intValue);
                            anonymousClass12.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7;
                            anonymousClass12.L$1 = flowCollector2;
                            anonymousClass12.L$2 = obj2;
                            anonymousClass12.L$3 = flowCollector3;
                            anonymousClass12.L$4 = iArr2;
                            anonymousClass12.L$5 = iArr;
                            anonymousClass12.I$0 = length;
                            anonymousClass12.I$1 = i2;
                            anonymousClass12.I$2 = i7;
                            anonymousClass12.I$3 = intValue;
                            anonymousClass12.label = 1;
                            Object emit = flowCollector3.emit(boxInt, anonymousClass12);
                            flowCollector4 = flowCollector3;
                            if (emit == obj) {
                                return obj;
                            }
                            i2++;
                            flowCollector3 = flowCollector4;
                            if (i2 < length) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj3);
                    int[] iArr4 = this.$this_asFlow$inlined;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 = this;
                    iArr = iArr4;
                    iArr2 = iArr;
                    obj = coroutine_suspended;
                    length = iArr4.length;
                    FlowCollector<? super Integer> flowCollector5 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    obj2 = anonymousClass12;
                    flowCollector2 = flowCollector5;
                    i2 = 0;
                    flowCollector3 = flowCollector5;
                    if (i2 < length) {
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj32 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i == 0) {
        }
    }
}
