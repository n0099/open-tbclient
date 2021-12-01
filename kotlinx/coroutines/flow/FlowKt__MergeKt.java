package kotlinx.coroutines.flow;

import com.tachikoma.core.component.anim.AnimationProperty;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a;\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001ag\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aj\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001aq\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u001127\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001ac\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\r\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000f\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u001aH\u0007¢\u0006\u0004\b\u0004\u0010\u001b\u001at\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\r\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001c¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\"\"\u0010\"\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\"\u001c\u0010)\u001a\u00020(8\u0006@\u0007X\u0087T¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"T", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "merge", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", AnimationProperty.TRANSFORM, "flatMapConcat", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "", "concurrency", "flatMapMerge", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flattenMerge", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "mapLatest", "", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "transformLatest", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "DEFAULT_CONCURRENCY", "I", "getDEFAULT_CONCURRENCY", "()I", "DEFAULT_CONCURRENCY$annotations", "()V", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "DEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__MergeKt {
    public static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp(FlowKt.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);

    @FlowPreview
    public static /* synthetic */ void DEFAULT_CONCURRENCY$annotations() {
    }

    @FlowPreview
    public static final <T, R> Flow<R> flatMapConcat(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenConcat(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                public final /* synthetic */ FlowKt__MergeKt$flatMapConcat$$inlined$map$1 this$0;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\n"}, d2 = {"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$1$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {138, 138}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FlowKt__MergeKt$flatMapConcat$$inlined$map$1 flowKt__MergeKt$flatMapConcat$$inlined$map$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.this$0 = flowKt__MergeKt$flatMapConcat$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i2;
                    AnonymousClass2 anonymousClass2;
                    Object obj3;
                    Object obj4;
                    Object obj5;
                    FlowCollector flowCollector;
                    AnonymousClass1 anonymousClass12;
                    AnonymousClass1 anonymousClass13;
                    FlowCollector flowCollector2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i3 = anonymousClass1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i3 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i2 = anonymousClass1.label;
                            if (i2 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.$this_unsafeFlow$inlined;
                                Function2 function2 = function2;
                                anonymousClass1.L$0 = this;
                                anonymousClass1.L$1 = obj;
                                anonymousClass1.L$2 = anonymousClass1;
                                anonymousClass1.L$3 = obj;
                                anonymousClass1.L$4 = anonymousClass1;
                                anonymousClass1.L$5 = obj;
                                anonymousClass1.L$6 = flowCollector3;
                                anonymousClass1.L$7 = flowCollector3;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = this;
                                obj3 = obj;
                                obj4 = obj3;
                                obj5 = obj4;
                                flowCollector = flowCollector3;
                                anonymousClass12 = anonymousClass1;
                                anonymousClass13 = anonymousClass12;
                                obj2 = invoke;
                                flowCollector2 = flowCollector;
                            } else if (i2 != 1) {
                                if (i2 == 2) {
                                    FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$6;
                                    Object obj6 = anonymousClass1.L$5;
                                    AnonymousClass1 anonymousClass14 = (AnonymousClass1) anonymousClass1.L$4;
                                    Object obj7 = anonymousClass1.L$3;
                                    AnonymousClass1 anonymousClass15 = (AnonymousClass1) anonymousClass1.L$2;
                                    Object obj8 = anonymousClass1.L$1;
                                    AnonymousClass2 anonymousClass22 = (AnonymousClass2) anonymousClass1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                flowCollector = (FlowCollector) anonymousClass1.L$7;
                                flowCollector2 = (FlowCollector) anonymousClass1.L$6;
                                obj3 = anonymousClass1.L$5;
                                anonymousClass12 = (AnonymousClass1) anonymousClass1.L$4;
                                obj4 = anonymousClass1.L$3;
                                anonymousClass13 = (AnonymousClass1) anonymousClass1.L$2;
                                obj5 = anonymousClass1.L$1;
                                anonymousClass2 = (AnonymousClass2) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            anonymousClass1.L$0 = anonymousClass2;
                            anonymousClass1.L$1 = obj5;
                            anonymousClass1.L$2 = anonymousClass13;
                            anonymousClass1.L$3 = obj4;
                            anonymousClass1.L$4 = anonymousClass12;
                            anonymousClass1.L$5 = obj3;
                            anonymousClass1.L$6 = flowCollector2;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = anonymousClass1.label;
                    if (i2 != 0) {
                    }
                    anonymousClass1.L$0 = anonymousClass2;
                    anonymousClass1.L$1 = obj5;
                    anonymousClass1.L$2 = anonymousClass13;
                    anonymousClass1.L$3 = obj4;
                    anonymousClass1.L$4 = anonymousClass12;
                    anonymousClass1.L$5 = obj3;
                    anonymousClass1.L$6 = flowCollector2;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> flow, @BuilderInference Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$flatMapLatest$1(function2, null));
    }

    @FlowPreview
    public static final <T, R> Flow<R> flatMapMerge(final Flow<? extends T> flow, int i2, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenMerge(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                public final /* synthetic */ FlowKt__MergeKt$flatMapMerge$$inlined$map$1 this$0;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\n"}, d2 = {"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$2$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {138, 138}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FlowKt__MergeKt$flatMapMerge$$inlined$map$1 flowKt__MergeKt$flatMapMerge$$inlined$map$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.this$0 = flowKt__MergeKt$flatMapMerge$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i2;
                    AnonymousClass2 anonymousClass2;
                    Object obj3;
                    Object obj4;
                    Object obj5;
                    FlowCollector flowCollector;
                    AnonymousClass1 anonymousClass12;
                    AnonymousClass1 anonymousClass13;
                    FlowCollector flowCollector2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i3 = anonymousClass1.label;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i3 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i2 = anonymousClass1.label;
                            if (i2 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.$this_unsafeFlow$inlined;
                                Function2 function2 = function2;
                                anonymousClass1.L$0 = this;
                                anonymousClass1.L$1 = obj;
                                anonymousClass1.L$2 = anonymousClass1;
                                anonymousClass1.L$3 = obj;
                                anonymousClass1.L$4 = anonymousClass1;
                                anonymousClass1.L$5 = obj;
                                anonymousClass1.L$6 = flowCollector3;
                                anonymousClass1.L$7 = flowCollector3;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = this;
                                obj3 = obj;
                                obj4 = obj3;
                                obj5 = obj4;
                                flowCollector = flowCollector3;
                                anonymousClass12 = anonymousClass1;
                                anonymousClass13 = anonymousClass12;
                                obj2 = invoke;
                                flowCollector2 = flowCollector;
                            } else if (i2 != 1) {
                                if (i2 == 2) {
                                    FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$6;
                                    Object obj6 = anonymousClass1.L$5;
                                    AnonymousClass1 anonymousClass14 = (AnonymousClass1) anonymousClass1.L$4;
                                    Object obj7 = anonymousClass1.L$3;
                                    AnonymousClass1 anonymousClass15 = (AnonymousClass1) anonymousClass1.L$2;
                                    Object obj8 = anonymousClass1.L$1;
                                    AnonymousClass2 anonymousClass22 = (AnonymousClass2) anonymousClass1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                flowCollector = (FlowCollector) anonymousClass1.L$7;
                                flowCollector2 = (FlowCollector) anonymousClass1.L$6;
                                obj3 = anonymousClass1.L$5;
                                anonymousClass12 = (AnonymousClass1) anonymousClass1.L$4;
                                obj4 = anonymousClass1.L$3;
                                anonymousClass13 = (AnonymousClass1) anonymousClass1.L$2;
                                obj5 = anonymousClass1.L$1;
                                anonymousClass2 = (AnonymousClass2) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            anonymousClass1.L$0 = anonymousClass2;
                            anonymousClass1.L$1 = obj5;
                            anonymousClass1.L$2 = anonymousClass13;
                            anonymousClass1.L$3 = obj4;
                            anonymousClass1.L$4 = anonymousClass12;
                            anonymousClass1.L$5 = obj3;
                            anonymousClass1.L$6 = flowCollector2;
                            anonymousClass1.label = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = anonymousClass1.label;
                    if (i2 != 0) {
                    }
                    anonymousClass1.L$0 = anonymousClass2;
                    anonymousClass1.L$1 = obj5;
                    anonymousClass1.L$2 = anonymousClass13;
                    anonymousClass1.L$3 = obj4;
                    anonymousClass1.L$4 = anonymousClass12;
                    anonymousClass1.L$5 = obj3;
                    anonymousClass1.L$6 = flowCollector2;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, i2);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int i2, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, i2, function2);
    }

    @FlowPreview
    public static final <T> Flow<T> flattenConcat(final Flow<? extends Flow<? extends T>> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(final FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new FlowCollector<Flow<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1$lambda$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object obj, Continuation continuation2) {
                        Object collect2 = ((Flow) obj).collect(FlowCollector.this, continuation2);
                        return collect2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect2 : Unit.INSTANCE;
                    }
                }, continuation);
                return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    @FlowPreview
    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> flow, int i2) {
        if (i2 > 0) {
            return i2 == 1 ? FlowKt.flattenConcat(flow) : new ChannelFlowMerge(flow, i2, null, 0, 12, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i2).toString());
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, i2);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow, @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, 6, null);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, 12, null);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> merge(Flow<? extends T>... flowArr) {
        return FlowKt.merge(ArraysKt___ArraysKt.asIterable(flowArr));
    }
}
