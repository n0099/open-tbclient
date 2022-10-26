package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0015\u001a[\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u001624\b\u0001\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a%\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b \u0010\u0015\u001a\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\b*\u00020\"¢\u0006\u0004\b \u0010#\u001a\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020$¢\u0006\u0004\b \u0010&\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000'¢\u0006\u0004\b \u0010(\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0004\b \u0010*\u001a\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\b*\u00020+¢\u0006\u0004\b \u0010,\u001a\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020-¢\u0006\u0004\b \u0010.\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000/¢\u0006\u0004\b \u00100\u001a8\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000501H\u0007ø\u0001\u0000¢\u0006\u0004\b \u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlinx/coroutines/flow/Flow;", "callbackFlow", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "value", "flowOf", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "", "elements", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "", "bufferSize", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/ParameterName;", "name", "channel", "flowViaChannel", "(ILkotlin/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "asFlow", "(Lkotlin/Function0;)Lkotlinx/coroutines/flow/Flow;", "", "([I)Lkotlinx/coroutines/flow/Flow;", "", "", "([J)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/util/Iterator;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes8.dex */
public final /* synthetic */ class FlowKt__BuildersKt {
    public static final Flow asFlow(Iterable iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    public static final Flow callbackFlow(Function2 function2) {
        return new CallbackFlowBuilder(function2, null, 0, 6, null);
    }

    public static final Flow channelFlow(Function2 function2) {
        return new ChannelFlowBuilder(function2, null, 0, 6, null);
    }

    public static final Flow flow(Function2 function2) {
        return new SafeFlow(function2);
    }

    public static final Flow flowOf(final Object obj) {
        return new Flow() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object emit = flowCollector.emit(obj, continuation);
                if (emit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final Flow asFlow(Iterator it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    public static final Flow flowOf(Object... objArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(objArr);
    }

    public static final Flow asFlow(final Function0 function0) {
        return new Flow() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object emit = flowCollector.emit(Function0.this.invoke(), continuation);
                if (emit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final Flow asFlow(Function1 function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    public static final Flow asFlow(IntRange intRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(intRange);
    }

    public static final Flow asFlow(LongRange longRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(longRange);
    }

    public static final Flow asFlow(Sequence sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    public static final Flow asFlow(int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    public static final Flow asFlow(long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    public static final Flow asFlow(Object[] objArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(objArr);
    }

    public static final Flow emptyFlow() {
        return EmptyFlow.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    public static final Flow flowViaChannel(int i, Function2 function2) {
        return FlowKt.buffer(FlowKt.channelFlow(new FlowKt__BuildersKt$flowViaChannel$1(function2, null)), i);
    }

    public static /* synthetic */ Flow flowViaChannel$default(int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return FlowKt.flowViaChannel(i, function2);
    }
}
