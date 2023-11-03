package kotlinx.coroutines.flow.internal;

import com.google.gson.internal.bind.TypeAdapters;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T1
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {TypeAdapters.AnonymousClass27.SECOND}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Flow<T1> $flow;
    public final /* synthetic */ Flow<T2> $flow2;
    public final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    public final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T2> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T1> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", AdvanceSetting.NETWORK_TYPE}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Object $cnt;
        public final /* synthetic */ Flow<T1> $flow;
        public final /* synthetic */ CoroutineContext $scopeContext;
        public final /* synthetic */ ReceiveChannel<Object> $second;
        public final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        public final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
        public int label;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T1> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Flow<? extends T1> flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return invoke2(unit, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1<T> implements FlowCollector, SuspendFunction {
            public final /* synthetic */ Object $cnt;
            public final /* synthetic */ CoroutineContext $scopeContext;
            public final /* synthetic */ ReceiveChannel<Object> $second;
            public final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            public final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
                this.$scopeContext = coroutineContext;
                this.$cnt = obj;
                this.$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = function3;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", AdvanceSetting.NETWORK_TYPE}, k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C07281 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                public final /* synthetic */ ReceiveChannel<Object> $second;
                public final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                public final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                public final /* synthetic */ T1 $value;
                public Object L$0;
                public int label;

                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
                /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C07281(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, T1 t1, Continuation<? super C07281> continuation) {
                    super(2, continuation);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = function3;
                    this.$value = t1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C07281(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                    return invoke2(unit, continuation);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit unit, Continuation<? super Unit> continuation) {
                    return ((C07281) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    Object mo2302receiveCatchingJP2dKIU;
                    FlowCollector flowCollector;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            flowCollector = (FlowCollector) this.L$0;
                            this.L$0 = null;
                            this.label = 3;
                            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        mo2302receiveCatchingJP2dKIU = ((ChannelResult) obj).m2321unboximpl();
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel<Object> receiveChannel = this.$second;
                        this.label = 1;
                        mo2302receiveCatchingJP2dKIU = receiveChannel.mo2302receiveCatchingJP2dKIU(this);
                        if (mo2302receiveCatchingJP2dKIU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    FlowCollector flowCollector2 = this.$this_unsafeFlow;
                    if (mo2302receiveCatchingJP2dKIU instanceof ChannelResult.Failed) {
                        Throwable m2313exceptionOrNullimpl = ChannelResult.m2313exceptionOrNullimpl(mo2302receiveCatchingJP2dKIU);
                        if (m2313exceptionOrNullimpl == null) {
                            throw new AbortFlowException(flowCollector2);
                        }
                        throw m2313exceptionOrNullimpl;
                    }
                    Function3<T1, T2, Continuation<? super R>, Object> function3 = this.$transform;
                    T1 t1 = this.$value;
                    if (mo2302receiveCatchingJP2dKIU == NullSurrogateKt.NULL) {
                        mo2302receiveCatchingJP2dKIU = null;
                    }
                    this.L$0 = flowCollector2;
                    this.label = 2;
                    obj = function3.invoke(t1, mo2302receiveCatchingJP2dKIU, this);
                    flowCollector = flowCollector2;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = null;
                    this.label = 3;
                    if (flowCollector.emit(obj, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T1 t1, Continuation<? super Unit> continuation) {
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                int i;
                if (continuation instanceof CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (CombineKt$zipImpl$1$1$2$1$emit$1) continuation;
                    int i2 = combineKt$zipImpl$1$1$2$1$emit$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.label = i2 - Integer.MIN_VALUE;
                        Object obj = combineKt$zipImpl$1$1$2$1$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                        if (i == 0) {
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            CoroutineContext coroutineContext = this.$scopeContext;
                            Unit unit = Unit.INSTANCE;
                            Object obj2 = this.$cnt;
                            C07281 c07281 = new C07281(this.$second, this.$this_unsafeFlow, this.$transform, t1, null);
                            combineKt$zipImpl$1$1$2$1$emit$1.label = 1;
                            if (ChannelFlowKt.withContextUndispatched(coroutineContext, unit, obj2, c07281, combineKt$zipImpl$1$1$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                Object obj3 = combineKt$zipImpl$1$1$2$1$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                if (i == 0) {
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Flow<T1> flow = this.$flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x001b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x000a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0018 */
    /* JADX DEBUG: Type inference failed for r12v4. Raw type applied. Possible types: kotlinx.coroutines.flow.Flow<T1>, kotlinx.coroutines.flow.Flow */
    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: kotlinx.coroutines.flow.Flow<T2>, kotlinx.coroutines.flow.Flow */
    /* JADX DEBUG: Type inference failed for r2v4. Raw type applied. Possible types: kotlinx.coroutines.flow.FlowCollector<R>, kotlinx.coroutines.flow.FlowCollector */
    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: kotlinx.coroutines.flow.FlowCollector<R>, kotlinx.coroutines.flow.FlowCollector */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: kotlinx.coroutines.flow.FlowCollector<R>, kotlinx.coroutines.flow.FlowCollector */
    /* JADX DEBUG: Type inference failed for r6v1. Raw type applied. Possible types: kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object>, kotlin.jvm.functions.Function3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CompletableJob Job$default;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineContext plus;
        Unit unit;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ReceiveChannel receiveChannel3 = this.label;
        try {
            if (receiveChannel3 != 0) {
                if (receiveChannel3 == 1) {
                    receiveChannel2 = (ReceiveChannel) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel3 = receiveChannel2;
                    } catch (AbortFlowException e) {
                        e = e;
                    }
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            final FlowCollector flowCollector = this.$this_unsafeFlow;
            ((SendChannel) produce$default).mo2363invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (CompletableJob.this.isActive()) {
                        CompletableJob.this.cancel((CancellationException) new AbortFlowException(flowCollector));
                    }
                }
            });
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object threadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                plus = coroutineScope.getCoroutineContext().plus(Job$default);
                unit = Unit.INSTANCE;
                anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContext, threadContextElements, produce$default, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = produce$default;
                this.label = 1;
                receiveChannel = produce$default;
                try {
                } catch (AbortFlowException e2) {
                    e = e2;
                    receiveChannel2 = receiveChannel;
                    FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
                    receiveChannel3 = receiveChannel2;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    receiveChannel3 = receiveChannel;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel = produce$default;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = produce$default;
            }
            if (ChannelFlowKt.withContextUndispatched$default(plus, unit, null, anonymousClass2, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel3 = receiveChannel;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
            FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
            receiveChannel3 = receiveChannel2;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
