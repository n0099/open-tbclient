package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt__ReduceKt$fold$$inlined$collect$2 implements FlowCollector<T> {
    public final /* synthetic */ Ref.ObjectRef $accumulator$inlined;
    public final /* synthetic */ Function3 $operation$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\u0007"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$2", f = "Reduce.kt", i = {0, 0, 0, 0}, l = {Cea708Decoder.COMMAND_DSW}, m = "emit", n = {"this", "value", "continuation", "value"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$2$1  reason: invalid class name */
    /* loaded from: classes8.dex */
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
            return FlowKt__ReduceKt$fold$$inlined$collect$2.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$fold$$inlined$collect$2(Ref.ObjectRef objectRef, Function3 function3) {
        this.$accumulator$inlined = objectRef;
        this.$operation$inlined = function3;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    public Object emit$$forInline(Object obj, Continuation continuation) {
        InlineMarker.mark(4);
        new AnonymousClass1(continuation);
        InlineMarker.mark(5);
        Ref.ObjectRef objectRef = this.$accumulator$inlined;
        objectRef.element = this.$operation$inlined.invoke(objectRef.element, obj, continuation);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r8v4, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r8v5, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        T t;
        Ref.ObjectRef objectRef;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) anonymousClass1.L$4;
                        Object obj3 = anonymousClass1.L$3;
                        Continuation continuation2 = (Continuation) anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$1;
                        FlowKt__ReduceKt$fold$$inlined$collect$2 flowKt__ReduceKt$fold$$inlined$collect$2 = (FlowKt__ReduceKt$fold$$inlined$collect$2) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        t = obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef2 = this.$accumulator$inlined;
                    Function3 function3 = this.$operation$inlined;
                    T t2 = objectRef2.element;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = obj;
                    anonymousClass1.L$2 = anonymousClass1;
                    anonymousClass1.L$3 = obj;
                    anonymousClass1.L$4 = objectRef2;
                    anonymousClass1.label = 1;
                    Object invoke = function3.invoke(t2, obj, anonymousClass1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t = invoke;
                    objectRef = objectRef2;
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i == 0) {
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
