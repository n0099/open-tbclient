package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a]\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\t\u001a\u00028\u0001H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/coroutines/CoroutineContext;", "newContext", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "value", "withContextUndispatched", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "asChannelFlow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "withUndispatchedContextCollector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ChannelFlowKt {
    public static final FlowCollector withUndispatchedContextCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        if (!(flowCollector instanceof SendingCollector) && !(flowCollector instanceof NopCollector)) {
            return new UndispatchedContextCollector(flowCollector, coroutineContext);
        }
        return flowCollector;
    }

    public static final ChannelFlow asChannelFlow(Flow flow) {
        Flow flow2;
        if (!(flow instanceof ChannelFlow)) {
            flow2 = null;
        } else {
            flow2 = flow;
        }
        ChannelFlow channelFlow = (ChannelFlow) flow2;
        if (channelFlow == null) {
            return new ChannelFlowOperatorImpl(flow, null, 0, 6, null);
        }
        return channelFlow;
    }

    public static final /* synthetic */ Object withContextUndispatched(final CoroutineContext coroutineContext, final Object obj, final Function2 function2, final Object obj2, final Continuation continuation) {
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            Continuation continuation2 = new Continuation() { // from class: kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                @Override // kotlin.coroutines.Continuation
                public CoroutineContext getContext() {
                    return CoroutineContext.this;
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj3) {
                    continuation.resumeWith(obj3);
                }
            };
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(obj2, continuation2);
                ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                if (invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            throw th;
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object obj, Function2 function2, Object obj2, Continuation continuation, int i, Object obj3) {
        if ((i & 2) != 0) {
            obj = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, function2, obj2, continuation);
    }
}
