package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a]\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007¢\u0006\u0004\b\u0002\u0010\u000b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a|\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r28\b\u0004\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "distinctUntilChanged", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/Function2;)Lkotlinx/coroutines/flow/Flow;", "K", "Lkotlin/Function1;", "keySelector", "distinctUntilChangedBy", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/Function1;)Lkotlinx/coroutines/flow/Flow;", "distinctUntilChangedBy$FlowKt__DistinctKt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/Function1;Lkotlin/Function2;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__DistinctKt {
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow) {
        return FlowKt.distinctUntilChangedBy(flow, FlowKt__DistinctKt$distinctUntilChanged$1.INSTANCE);
    }

    @FlowPreview
    public static final <T, K> Flow<T> distinctUntilChangedBy(final Flow<? extends T> flow, final Function1<? super T, ? extends K> function1) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2  reason: invalid class name */
            /* loaded from: classes8.dex */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                public final /* synthetic */ Ref.ObjectRef $previousKey$inlined;
                public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                public final /* synthetic */ FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1 this$0;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\t"}, d2 = {"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$$special$$inlined$collect$2$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2", f = "Distinct.kt", i = {0, 0, 0, 0, 0}, l = {141}, m = "emit", n = {"this", "value", "continuation", "value", "key"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2$1  reason: invalid class name */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef, FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1 flowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.$previousKey$inlined = objectRef;
                    this.this$0 = flowKt__DistinctKt$distinctUntilChangedBy$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
                /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Object] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i2;
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
                                ?? invoke = function1.invoke(obj);
                                T t = this.$previousKey$inlined.element;
                                if (t == NullSurrogateKt.NULL || !Boxing.boxBoolean(Intrinsics.areEqual(t, (Object) invoke)).booleanValue()) {
                                    this.$previousKey$inlined.element = invoke;
                                    FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                                    anonymousClass1.L$0 = this;
                                    anonymousClass1.L$1 = obj;
                                    anonymousClass1.L$2 = anonymousClass1;
                                    anonymousClass1.L$3 = obj;
                                    anonymousClass1.L$4 = invoke;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj3 = anonymousClass1.L$4;
                                Object obj4 = anonymousClass1.L$3;
                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$2;
                                Object obj5 = anonymousClass1.L$1;
                                AnonymousClass2 anonymousClass2 = (AnonymousClass2) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
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
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.internal.Symbol, T] */
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, objectRef, this), continuation);
                return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public static final <T, K> Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(Flow<? extends T> flow, Function1<? super T, ? extends K> function1, Function2<? super K, ? super K, Boolean> function2) {
        return new FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$3(flow, function1, function2);
    }

    @FlowPreview
    public static final <T> Flow<T> distinctUntilChanged(final Flow<? extends T> flow, final Function2<? super T, ? super T, Boolean> function2) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$1$lambda$1"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2  reason: invalid class name */
            /* loaded from: classes8.dex */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                public final /* synthetic */ Ref.ObjectRef $previousKey$inlined;
                public final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                public final /* synthetic */ FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1 this$0;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\t"}, d2 = {"emit", "", "T", "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$$special$$inlined$collect$1$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$1$lambda$1$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2", f = "Distinct.kt", i = {0, 0, 0, 0, 0}, l = {141}, m = "emit", n = {"this", "value", "continuation", "value", "key"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2$1  reason: invalid class name */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef, FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1 flowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.$previousKey$inlined = objectRef;
                    this.this$0 = flowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i2;
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
                                T t = this.$previousKey$inlined.element;
                                if (t == NullSurrogateKt.NULL || !((Boolean) function2.invoke(t, obj)).booleanValue()) {
                                    this.$previousKey$inlined.element = obj;
                                    FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                                    anonymousClass1.L$0 = this;
                                    anonymousClass1.L$1 = obj;
                                    anonymousClass1.L$2 = anonymousClass1;
                                    anonymousClass1.L$3 = obj;
                                    anonymousClass1.L$4 = obj;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj3 = anonymousClass1.L$4;
                                Object obj4 = anonymousClass1.L$3;
                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$2;
                                Object obj5 = anonymousClass1.L$1;
                                AnonymousClass2 anonymousClass2 = (AnonymousClass2) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
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
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.internal.Symbol, T] */
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, objectRef, this), continuation);
                return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
