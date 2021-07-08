package kotlinx.coroutines.flow.internal;

import com.baidu.mobstat.Config;
import com.google.gson.internal.bind.TypeAdapters;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001ap\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010*\u00020\u000f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010*\u00020\u000f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u0090\u0001\u0010\u001c\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0014\u0010\u0017\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00162\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00160\u001829\u0010\f\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\u001bH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¤\u0001\u0010%\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062W\u0010\f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0015\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 ¢\u0006\u0002\b\u001bH\u0080@ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ax\u0010.\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u001a0'2\u0006\u0010)\u001a\u00020(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u000e\b\u0004\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001823\b\b\u0010.\u001a-\b\u0001\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0,H\u0082\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "getNull", "()Lkotlinx/coroutines/internal/Symbol;", "T1", "T2", "R", "Lkotlinx/coroutines/flow/Flow;", "flow", "flow2", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "transform", "zipImpl", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "asChannel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/channels/ReceiveChannel;", "asFairChannel", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "flows", "Lkotlin/Function0;", "arrayFactory", "", "Lkotlin/ExtensionFunctionType;", "combineInternal", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Config.TRACE_VISIT_FIRST, TypeAdapters.AnonymousClass27.SECOND, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "a", "b", "combineTransformInternal", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "isClosed", "channel", "onClosed", "Lkotlin/Function2;", "value", "onReceive", "(Lkotlinx/coroutines/selects/SelectBuilder;ZLkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class CombineKt {
    public static final ReceiveChannel<Object> asChannel(CoroutineScope coroutineScope, Flow<?> flow) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new CombineKt$asChannel$1(flow, null), 3, null);
    }

    public static final ReceiveChannel<Object> asFairChannel(CoroutineScope coroutineScope, Flow<?> flow) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new CombineKt$asFairChannel$1(flow, null), 3, null);
    }

    @PublishedApi
    public static final <R, T> Object combineInternal(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$combineInternal$2(flowCollector, flowArr, function0, function3, null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static final <T1, T2, R> Object combineTransformInternal(FlowCollector<? super R> flowCollector, Flow<? extends T1> flow, Flow<? extends T2> flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$combineTransformInternal$2(flowCollector, flow, flow2, function4, null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static final Symbol getNull() {
        return NullSurrogateKt.NULL;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<? extends java.lang.Object>, kotlinx.coroutines.selects.SelectClause1<? extends Q> */
    public static final void onReceive(SelectBuilder<? super Unit> selectBuilder, boolean z, ReceiveChannel<? extends Object> receiveChannel, Function0<Unit> function0, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (z) {
            return;
        }
        selectBuilder.invoke(receiveChannel.getOnReceiveOrNull(), new CombineKt$onReceive$1(function0, function2, null));
    }

    public static final <T1, T2, R> Flow<R> zipImpl(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new CombineKt$zipImpl$$inlined$unsafeFlow$1(flow, flow2, function3);
    }
}
