package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ T $initialValue;
    public final /* synthetic */ MutableSharedFlow<T> $shared;
    public final /* synthetic */ SharingStarted $started;
    public final /* synthetic */ Flow<T> $upstream;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.$started = sharingStarted;
        this.$upstream = flow;
        this.$shared = mutableSharedFlow;
        this.$initialValue = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        public /* synthetic */ int I$0;
        public int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object invoke(int i, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.I$0 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        public final /* synthetic */ T $initialValue;
        public final /* synthetic */ MutableSharedFlow<T> $shared;
        public final /* synthetic */ Flow<T> $upstream;
        public /* synthetic */ Object L$0;
        public int label;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings */
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                iArr[SharingCommand.START.ordinal()] = 1;
                iArr[SharingCommand.STOP.ordinal()] = 2;
                iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$upstream = flow;
            this.$shared = mutableSharedFlow;
            this.$initialValue = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return invoke2(sharingCommand, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
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
                int i2 = WhenMappings.$EnumSwitchMapping$0[((SharingCommand) this.L$0).ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        T t = this.$initialValue;
                        if (t == SharedFlowKt.NO_VALUE) {
                            this.$shared.resetReplayCache();
                        } else {
                            this.$shared.tryEmit(t);
                        }
                    }
                } else {
                    Flow<T> flow = this.$upstream;
                    SharedFlow sharedFlow = this.$shared;
                    this.label = 1;
                    if (flow.collect(sharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Flow<T> flow;
        SharedFlow sharedFlow;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    flow = this.$upstream;
                    sharedFlow = this.$shared;
                    this.label = 3;
                    if (flow.collect(sharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$started == SharingStarted.Companion.getEagerly()) {
            Flow<T> flow2 = this.$upstream;
            SharedFlow sharedFlow2 = this.$shared;
            this.label = 1;
            if (flow2.collect(sharedFlow2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (this.$started == SharingStarted.Companion.getLazily()) {
            StateFlow<Integer> subscriptionCount = this.$shared.getSubscriptionCount();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 2;
            if (FlowKt.first(subscriptionCount, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flow = this.$upstream;
            sharedFlow = this.$shared;
            this.label = 3;
            if (flow.collect(sharedFlow, this) == coroutine_suspended) {
            }
        } else {
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(this.$started.command(this.$shared.getSubscriptionCount()));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, null);
            this.label = 4;
            if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
