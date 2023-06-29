package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ FlowCollector<R> $collector;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> continuation) {
        super(2, continuation);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, continuation);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1<T> implements FlowCollector, SuspendFunction {
        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
        public final /* synthetic */ FlowCollector<R> $collector;
        public final /* synthetic */ Ref.ObjectRef<Job> $previousFlow;
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector) {
            this.$previousFlow = objectRef;
            this.$$this$coroutineScope = coroutineScope;
            this.this$0 = channelFlowTransformLatest;
            this.$collector = flowCollector;
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ FlowCollector<R> $collector;
            public final /* synthetic */ T $value;
            public int label;
            public final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = channelFlowTransformLatest;
                this.$collector = flowCollector;
                this.$value = t;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return invoke2(coroutineScope, continuation);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Function3 function3;
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
                    function3 = this.this$0.transform;
                    Object obj2 = this.$collector;
                    T t = this.$value;
                    this.label = 1;
                    if (function3.invoke(obj2, t, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
            int i;
            AnonymousClass1<T> anonymousClass1;
            Job launch$default;
            if (continuation instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) continuation;
                int i2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            Job job = (Job) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$2;
                            t = (T) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1;
                            anonymousClass1 = (AnonymousClass1) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Job job2 = this.$previousFlow.element;
                        if (job2 != null) {
                            job2.cancel((CancellationException) new ChildCancelledException());
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0 = this;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1 = t;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$2 = job2;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.label = 1;
                            if (job2.join(channelFlowTransformLatest$flowCollect$3$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        anonymousClass1 = this;
                    }
                    Ref.ObjectRef<Job> objectRef = anonymousClass1.$previousFlow;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.this$0, anonymousClass1.$collector, t, null), 1, null);
                    objectRef.element = (T) launch$default;
                    return Unit.INSTANCE;
                }
            }
            channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
            Object obj2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
            if (i == 0) {
            }
            Ref.ObjectRef<Job> objectRef2 = anonymousClass1.$previousFlow;
            launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.this$0, anonymousClass1.$collector, t, null), 1, null);
            objectRef2.element = (T) launch$default;
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
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
            Flow<S> flow = channelFlowTransformLatest.flow;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, (CoroutineScope) this.L$0, channelFlowTransformLatest, this.$collector);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
