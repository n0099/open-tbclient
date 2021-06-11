package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ FlowCollector $this_unsafeFlow;
    public Object L$0;
    public Object L$1;
    public Object L$10;
    public Object L$11;
    public Object L$12;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public Object L$8;
    public Object L$9;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", AdvanceSetting.NETWORK_TYPE, "", "invoke", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ ReceiveChannel $first;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReceiveChannel receiveChannel) {
            super(1);
            this.$first = receiveChannel;
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
            if (this.$first.isClosedForReceive()) {
                return;
            }
            this.$first.cancel((CancellationException) new AbortFlowException(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this.$this_unsafeFlow));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x02a3 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018c A[Catch: all -> 0x0274, TRY_LEAVE, TryCatch #3 {all -> 0x0274, blocks: (B:36:0x0184, B:38:0x018c, B:67:0x025c), top: B:107:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01cf A[Catch: all -> 0x0258, TryCatch #7 {all -> 0x0258, blocks: (B:42:0x01c1, B:45:0x01cf, B:49:0x01e0, B:52:0x01eb), top: B:113:0x01c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0244 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x025c A[Catch: all -> 0x0274, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0274, blocks: (B:36:0x0184, B:38:0x018c, B:67:0x025c), top: B:107:0x0184 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0298  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0252 -> B:115:0x0155). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Object obj2;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        Throwable th;
        ChannelIterator channelIterator;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
        ReceiveChannel receiveChannel5;
        CoroutineScope coroutineScope;
        ChannelIterator channelIterator2;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
        Object obj3;
        ReceiveChannel receiveChannel6;
        Throwable th2;
        Object obj4;
        CoroutineScope coroutineScope2;
        Object obj5;
        ChannelIterator channelIterator3;
        ReceiveChannel receiveChannel7;
        ReceiveChannel receiveChannel8;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
        FlowCollector flowCollector;
        ChannelIterator channelIterator4;
        ReceiveChannel receiveChannel9;
        Throwable th3;
        Object obj6;
        Object obj7;
        Object obj8;
        CoroutineScope coroutineScope3;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
        ReceiveChannel receiveChannel10;
        ReceiveChannel receiveChannel11;
        Throwable th4;
        AbortFlowException abortFlowException;
        AbortFlowException e2;
        Throwable th5;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 = this.label;
        int i2 = 1;
        try {
            if (combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 != 0) {
                try {
                    if (combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 == 1) {
                        ChannelIterator channelIterator5 = (ChannelIterator) this.L$9;
                        ReceiveChannel receiveChannel12 = (ReceiveChannel) this.L$8;
                        Throwable th6 = (Throwable) this.L$7;
                        receiveChannel = (ReceiveChannel) this.L$6;
                        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$17 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                        ReceiveChannel receiveChannel13 = (ReceiveChannel) this.L$4;
                        ChannelIterator channelIterator6 = (ChannelIterator) this.L$3;
                        receiveChannel2 = (ReceiveChannel) this.L$2;
                        ReceiveChannel receiveChannel14 = (ReceiveChannel) this.L$1;
                        CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = obj;
                        receiveChannel3 = receiveChannel14;
                        receiveChannel4 = receiveChannel13;
                        th = th6;
                        channelIterator = channelIterator5;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                        receiveChannel5 = receiveChannel12;
                        coroutineScope = coroutineScope4;
                        channelIterator2 = channelIterator6;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$17;
                        if (!((Boolean) obj2).booleanValue()) {
                        }
                    } else if (combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 == 2) {
                        Object obj9 = this.L$11;
                        Object obj10 = this.L$10;
                        channelIterator = (ChannelIterator) this.L$9;
                        ReceiveChannel receiveChannel15 = (ReceiveChannel) this.L$8;
                        Throwable th7 = (Throwable) this.L$7;
                        receiveChannel = (ReceiveChannel) this.L$6;
                        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$18 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                        ReceiveChannel receiveChannel16 = (ReceiveChannel) this.L$4;
                        ChannelIterator channelIterator7 = (ChannelIterator) this.L$3;
                        ReceiveChannel receiveChannel17 = (ReceiveChannel) this.L$2;
                        receiveChannel3 = (ReceiveChannel) this.L$1;
                        CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj3 = obj;
                        receiveChannel6 = receiveChannel17;
                        th2 = th7;
                        obj4 = obj9;
                        coroutineScope2 = coroutineScope5;
                        obj5 = obj10;
                        channelIterator3 = channelIterator7;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                        receiveChannel7 = receiveChannel15;
                        receiveChannel8 = receiveChannel16;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$18;
                        if (((Boolean) obj3).booleanValue()) {
                        }
                    } else if (combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 == 3) {
                        flowCollector = (FlowCollector) this.L$12;
                        Object obj11 = this.L$11;
                        Object obj12 = this.L$10;
                        ChannelIterator channelIterator8 = (ChannelIterator) this.L$9;
                        ReceiveChannel receiveChannel18 = (ReceiveChannel) this.L$8;
                        Throwable th8 = (Throwable) this.L$7;
                        ReceiveChannel receiveChannel19 = (ReceiveChannel) this.L$6;
                        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$19 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                        ReceiveChannel receiveChannel20 = (ReceiveChannel) this.L$4;
                        channelIterator4 = (ChannelIterator) this.L$3;
                        ReceiveChannel receiveChannel21 = (ReceiveChannel) this.L$2;
                        ReceiveChannel receiveChannel22 = (ReceiveChannel) this.L$1;
                        CoroutineScope coroutineScope6 = (CoroutineScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            receiveChannel9 = receiveChannel22;
                            channelIterator = channelIterator8;
                            th3 = th8;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                            obj6 = coroutine_suspended;
                            obj7 = obj;
                            receiveChannel2 = receiveChannel21;
                            obj8 = obj11;
                            coroutineScope3 = coroutineScope6;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$19;
                            obj5 = obj12;
                            receiveChannel7 = receiveChannel18;
                            receiveChannel = receiveChannel19;
                            receiveChannel10 = receiveChannel20;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel9;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel10;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj5;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj8;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 4;
                            if (flowCollector.emit(obj7, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) != obj6) {
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                            receiveChannel2 = receiveChannel21;
                            receiveChannel = receiveChannel19;
                        }
                    } else if (combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ChannelIterator channelIterator9 = (ChannelIterator) this.L$9;
                        receiveChannel7 = (ReceiveChannel) this.L$8;
                        Throwable th10 = (Throwable) this.L$7;
                        ReceiveChannel receiveChannel23 = (ReceiveChannel) this.L$6;
                        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$110 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                        ReceiveChannel receiveChannel24 = (ReceiveChannel) this.L$4;
                        ChannelIterator channelIterator10 = (ChannelIterator) this.L$3;
                        receiveChannel2 = (ReceiveChannel) this.L$2;
                        ReceiveChannel receiveChannel25 = (ReceiveChannel) this.L$1;
                        CoroutineScope coroutineScope7 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        channelIterator = channelIterator9;
                        coroutineScope2 = coroutineScope7;
                        receiveChannel11 = receiveChannel23;
                        receiveChannel8 = receiveChannel24;
                        receiveChannel = receiveChannel25;
                        th4 = th10;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$110;
                        channelIterator4 = channelIterator10;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                        try {
                            channelIterator3 = channelIterator4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel8;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel11;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = i2;
                            obj2 = channelIterator.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14);
                            if (obj2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ChannelIterator channelIterator11 = channelIterator3;
                            coroutineScope = coroutineScope2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                            channelIterator2 = channelIterator11;
                            CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$111 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                            receiveChannel4 = receiveChannel8;
                            receiveChannel5 = receiveChannel7;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$111;
                            ReceiveChannel receiveChannel26 = receiveChannel;
                            receiveChannel = receiveChannel11;
                            th = th4;
                            receiveChannel3 = receiveChannel26;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    obj5 = channelIterator.next();
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = receiveChannel3;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = receiveChannel2;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = channelIterator2;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel4;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel5;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = channelIterator;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$10 = obj5;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$11 = obj5;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 2;
                                    obj3 = channelIterator2.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12);
                                    if (obj3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel6 = receiveChannel2;
                                    th2 = th;
                                    obj4 = obj5;
                                    ChannelIterator channelIterator12 = channelIterator2;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                                    coroutineScope2 = coroutineScope;
                                    channelIterator3 = channelIterator12;
                                    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$112 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                                    receiveChannel7 = receiveChannel5;
                                    receiveChannel8 = receiveChannel4;
                                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$112;
                                    try {
                                        if (((Boolean) obj3).booleanValue()) {
                                            receiveChannel11 = receiveChannel;
                                            receiveChannel = receiveChannel3;
                                            th4 = th2;
                                            receiveChannel2 = receiveChannel6;
                                            i2 = 1;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel8;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel11;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th4;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = i2;
                                            obj2 = channelIterator.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14);
                                            if (obj2 != coroutine_suspended) {
                                            }
                                        } else {
                                            FlowCollector flowCollector2 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow;
                                            Function3 function3 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.this$0.$transform$inlined;
                                            Object obj13 = coroutine_suspended;
                                            Object obj14 = obj4 == NullSurrogateKt.NULL ? null : obj4;
                                            Symbol symbol = NullSurrogateKt.NULL;
                                            Object next = channelIterator3.next();
                                            if (next == symbol) {
                                                next = null;
                                            }
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel3;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel6;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel8;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th2;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj5;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj4;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$12 = flowCollector2;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 3;
                                            Object obj15 = obj14;
                                            CoroutineScope coroutineScope8 = coroutineScope2;
                                            obj7 = function3.invoke(obj15, next, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                                            obj6 = obj13;
                                            if (obj7 == obj6) {
                                                return obj6;
                                            }
                                            flowCollector = flowCollector2;
                                            receiveChannel9 = receiveChannel3;
                                            receiveChannel10 = receiveChannel8;
                                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                                            th3 = th2;
                                            receiveChannel2 = receiveChannel6;
                                            channelIterator4 = channelIterator3;
                                            obj8 = obj4;
                                            coroutineScope3 = coroutineScope8;
                                            try {
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope3;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel9;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator4;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel10;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th3;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj5;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj8;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 4;
                                                if (flowCollector.emit(obj7, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) != obj6) {
                                                    return obj6;
                                                }
                                                coroutine_suspended = obj6;
                                                coroutineScope2 = coroutineScope3;
                                                receiveChannel11 = receiveChannel;
                                                receiveChannel = receiveChannel9;
                                                Throwable th11 = th3;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
                                                receiveChannel8 = receiveChannel10;
                                                th4 = th11;
                                                channelIterator3 = channelIterator4;
                                                i2 = 1;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel8;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel11;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th4;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = i2;
                                                obj2 = channelIterator.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14);
                                                if (obj2 != coroutine_suspended) {
                                                }
                                            } catch (Throwable th12) {
                                                th = th12;
                                            }
                                        }
                                    } catch (Throwable th13) {
                                        th5 = th13;
                                        receiveChannel2 = receiveChannel6;
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        ChannelsKt.cancelConsumed(receiveChannel, th);
                                    } catch (AbortFlowException e3) {
                                        e2 = e3;
                                        FlowExceptions_commonKt.checkOwnership(e2, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.$this_unsafeFlow);
                                        if (!receiveChannel2.isClosedForReceive()) {
                                            abortFlowException = new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.$this_unsafeFlow);
                                            receiveChannel2.cancel((CancellationException) abortFlowException);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    if (!receiveChannel2.isClosedForReceive()) {
                                        abortFlowException = new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.$this_unsafeFlow);
                                        receiveChannel2.cancel((CancellationException) abortFlowException);
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th14) {
                                th5 = th14;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                            }
                        } catch (Throwable th15) {
                            th5 = th15;
                            receiveChannel = receiveChannel11;
                        }
                        i2 = 1;
                    }
                } catch (Throwable th16) {
                    th = th16;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = this.p$;
                receiveChannel = CombineKt.asChannel(coroutineScope2, this.this$0.$flow$inlined);
                receiveChannel2 = CombineKt.asChannel(coroutineScope2, this.this$0.$flow2$inlined);
                if (receiveChannel2 != null) {
                    ((SendChannel) receiveChannel2).invokeOnClose(new AnonymousClass1(receiveChannel));
                    channelIterator3 = receiveChannel2.iterator();
                    try {
                        channelIterator = receiveChannel.iterator();
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = this;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                        receiveChannel8 = receiveChannel;
                        receiveChannel11 = receiveChannel8;
                        receiveChannel7 = receiveChannel11;
                        th4 = null;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel2;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel8;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel11;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th4;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel7;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = i2;
                        obj2 = channelIterator.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14);
                        if (obj2 != coroutine_suspended) {
                        }
                    } catch (Throwable th17) {
                        th = th17;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                }
            }
            th5 = th;
            try {
                throw th5;
            } catch (Throwable th18) {
                try {
                    ChannelsKt.cancelConsumed(receiveChannel, th5);
                    throw th18;
                } catch (AbortFlowException e4) {
                    e2 = e4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    FlowExceptions_commonKt.checkOwnership(e2, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.$this_unsafeFlow);
                    if (!receiveChannel2.isClosedForReceive()) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th19) {
                    th = th19;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    if (!receiveChannel2.isClosedForReceive()) {
                        receiveChannel2.cancel((CancellationException) new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16.$this_unsafeFlow));
                    }
                    throw th;
                }
            }
        } catch (Throwable th20) {
            th = th20;
        }
    }
}
