package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0017\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\u001a\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lkotlinx/coroutines/channels/BroadcastChannel;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineStart;", "start", "broadcastIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consumeAsFlow", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "", "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "produceIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    @FlowPreview
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object emitAll = FlowKt.emitAll(flowCollector, BroadcastChannel.this.openSubscription(), continuation);
                return emitAll == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAll : Unit.INSTANCE;
            }
        };
    }

    @FlowPreview
    public static final <T> BroadcastChannel<T> broadcastIn(Flow<? extends T> flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart) {
        return ChannelFlowKt.asChannelFlow(flow).broadcastImpl(coroutineScope, coroutineStart);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, 12, null);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0022 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x005f */
    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008b A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:65:0x0038, B:79:0x007f, B:81:0x008b, B:87:0x0099, B:88:0x009a, B:70:0x005b), top: B:102:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009a A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:65:0x0038, B:79:0x007f, B:81:0x008b, B:87:0x0099, B:88:0x009a, B:70:0x005b), top: B:102:0x0022 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x00ae -> B:66:0x003b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        int i;
        Throwable th;
        Throwable th2;
        FlowCollector flowCollector2;
        Object m2097unboximpl;
        ?? r10;
        Object receiveOrClosed;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                int i2 = flowKt__ChannelsKt$emitAllImpl$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__ChannelsKt$emitAllImpl$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        r10 = z;
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = r10;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = th;
                        flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
                        if (receiveOrClosed == coroutine_suspended) {
                        }
                    } else if (i == 1) {
                        FlowCollector flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$3;
                        th2 = (Throwable) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel<? extends T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector flowCollector4 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector4;
                        z = receiveChannel2;
                        m2097unboximpl = ((ValueOrClosed) obj).m2097unboximpl();
                        if (!ValueOrClosed.m2095isClosedimpl(m2097unboximpl)) {
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = flowKt__ChannelsKt$emitAllImpl$1.L$3;
                        th2 = (Throwable) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel<? extends T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        ReceiveChannel<? extends T> receiveChannel3 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector<? super T> flowCollector5 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<? super T> flowCollector6 = flowCollector5;
                        ReceiveChannel<? extends T> receiveChannel4 = receiveChannel3;
                        th = th2;
                        flowCollector = flowCollector6;
                        ReceiveChannel<? extends T> receiveChannel5 = receiveChannel4;
                        r10 = receiveChannel;
                        receiveChannel = receiveChannel5;
                        try {
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = r10;
                            flowKt__ChannelsKt$emitAllImpl$1.L$2 = th;
                            flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                            receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
                            if (receiveOrClosed == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowCollector2 = flowCollector;
                            th2 = th;
                            obj = receiveOrClosed;
                            ReceiveChannel<? extends T> receiveChannel6 = r10;
                            z = receiveChannel;
                            receiveChannel = receiveChannel6;
                            m2097unboximpl = ((ValueOrClosed) obj).m2097unboximpl();
                            if (!ValueOrClosed.m2095isClosedimpl(m2097unboximpl)) {
                                Throwable m2091getCloseCauseimpl = ValueOrClosed.m2091getCloseCauseimpl(m2097unboximpl);
                                if (m2091getCloseCauseimpl == null) {
                                    return Unit.INSTANCE;
                                }
                                throw m2091getCloseCauseimpl;
                            }
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = z;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.L$2 = th2;
                            flowKt__ChannelsKt$emitAllImpl$1.L$3 = m2097unboximpl;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                            Object emit = flowCollector2.emit((Object) ValueOrClosed.m2092getValueimpl(m2097unboximpl), flowKt__ChannelsKt$emitAllImpl$1);
                            flowCollector6 = flowCollector2;
                            receiveChannel4 = z;
                            if (emit == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            th = th2;
                            flowCollector = flowCollector6;
                            ReceiveChannel<? extends T> receiveChannel52 = receiveChannel4;
                            r10 = receiveChannel;
                            receiveChannel = receiveChannel52;
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = r10;
                            flowKt__ChannelsKt$emitAllImpl$1.L$2 = th;
                            flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                            receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
                            if (receiveOrClosed == coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            ReceiveChannel<? extends T> receiveChannel7 = r10;
                            z = receiveChannel;
                            receiveChannel = receiveChannel7;
                            try {
                                throw th;
                            } finally {
                                if (receiveChannel != null) {
                                    ChannelsKt.cancelConsumed(z, th);
                                }
                            }
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ChannelsKt$emitAllImpl$1.label;
    }

    @FlowPreview
    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, 12, null);
    }
}
