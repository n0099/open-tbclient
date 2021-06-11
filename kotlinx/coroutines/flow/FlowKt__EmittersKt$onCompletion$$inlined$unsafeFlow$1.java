package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.SafeCollector;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ Function3 $action$inlined;
    public final /* synthetic */ Flow $this_onCompletion$inlined;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¨\u0006\b"}, d2 = {"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {114, 122, 128}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "this", "collector", "continuation", "$receiver", "e", "this", "collector", "continuation", "$receiver", "safeCollector", "exception"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i2;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Object obj;
        Throwable th;
        FlowCollector flowCollector3;
        ThrowingCollector throwingCollector;
        Function3 function3;
        Throwable th2;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        Function3 function32;
        Throwable th3;
        try {
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i3 = anonymousClass1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i3 - Integer.MIN_VALUE;
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            Flow flow = this.$this_onCompletion$inlined;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = flowCollector;
                            anonymousClass1.L$2 = anonymousClass1;
                            anonymousClass1.L$3 = flowCollector;
                            anonymousClass1.label = 1;
                            obj2 = FlowKt.catchImpl(flow, flowCollector, anonymousClass1);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            flowCollector2 = flowCollector;
                            obj = anonymousClass1;
                        } catch (Throwable th4) {
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            flowCollector2 = flowCollector;
                            obj = anonymousClass1;
                            th = th4;
                            flowCollector3 = flowCollector2;
                            throwingCollector = new ThrowingCollector(th);
                            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                            anonymousClass1.L$1 = flowCollector2;
                            anonymousClass1.L$2 = obj;
                            anonymousClass1.L$3 = flowCollector3;
                            anonymousClass1.L$4 = th;
                            anonymousClass1.label = 2;
                            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, null, anonymousClass1) != coroutine_suspended) {
                            }
                        }
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            Throwable th5 = (Throwable) anonymousClass1.L$4;
                            FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                            Continuation continuation2 = (Continuation) anonymousClass1.L$2;
                            FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$1;
                            FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$12 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            throw th5;
                        } else if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            th3 = (Throwable) anonymousClass1.L$5;
                            safeCollector2 = (SafeCollector) anonymousClass1.L$4;
                            FlowCollector flowCollector6 = (FlowCollector) anonymousClass1.L$3;
                            Continuation continuation3 = (Continuation) anonymousClass1.L$2;
                            FlowCollector flowCollector7 = (FlowCollector) anonymousClass1.L$1;
                            FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$13 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                safeCollector2.releaseIntercepted();
                                if (th3 != null) {
                                    return Unit.INSTANCE;
                                }
                                throw th3;
                            } catch (Throwable th6) {
                                th = th6;
                                safeCollector2.releaseIntercepted();
                                throw th;
                            }
                        }
                    } else {
                        flowCollector = (FlowCollector) anonymousClass1.L$3;
                        obj = (Continuation) anonymousClass1.L$2;
                        flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (Throwable th7) {
                            flowCollector3 = flowCollector;
                            th = th7;
                            throwingCollector = new ThrowingCollector(th);
                            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                            anonymousClass1.L$1 = flowCollector2;
                            anonymousClass1.L$2 = obj;
                            anonymousClass1.L$3 = flowCollector3;
                            anonymousClass1.L$4 = th;
                            anonymousClass1.label = 2;
                            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, null, anonymousClass1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    }
                    th2 = (Throwable) obj2;
                    safeCollector = new SafeCollector(flowCollector, anonymousClass1.getContext());
                    function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                    anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                    anonymousClass1.L$1 = flowCollector2;
                    anonymousClass1.L$2 = obj;
                    anonymousClass1.L$3 = flowCollector;
                    anonymousClass1.L$4 = safeCollector;
                    anonymousClass1.L$5 = th2;
                    anonymousClass1.label = 3;
                    if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(safeCollector, function32, th2, anonymousClass1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th3 = th2;
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    if (th3 != null) {
                    }
                }
            }
            function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            anonymousClass1.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
            anonymousClass1.L$1 = flowCollector2;
            anonymousClass1.L$2 = obj;
            anonymousClass1.L$3 = flowCollector;
            anonymousClass1.L$4 = safeCollector;
            anonymousClass1.L$5 = th2;
            anonymousClass1.label = 3;
            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(safeCollector, function32, th2, anonymousClass1) != coroutine_suspended) {
            }
        } catch (Throwable th8) {
            th = th8;
            safeCollector2 = safeCollector;
            safeCollector2.releaseIntercepted();
            throw th;
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = anonymousClass1.label;
        if (i2 != 0) {
        }
        th2 = (Throwable) obj22;
        safeCollector = new SafeCollector(flowCollector, anonymousClass1.getContext());
    }
}
