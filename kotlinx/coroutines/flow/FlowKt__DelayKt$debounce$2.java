package kotlinx.coroutines.flow;

import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {185}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", SavedStateHandle.VALUES, "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class FlowKt__DelayKt$debounce$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Flow $this_debounce;
    public final /* synthetic */ long $timeoutMillis;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public CoroutineScope p$;
    public FlowCollector p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2(Flow flow, long j2, Continuation continuation) {
        super(3, continuation);
        this.$this_debounce = flow;
        this.$timeoutMillis = j2;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2 = new FlowKt__DelayKt$debounce$2(this.$this_debounce, this.$timeoutMillis, continuation);
        flowKt__DelayKt$debounce$2.p$ = coroutineScope;
        flowKt__DelayKt$debounce$2.p$0 = flowCollector;
        return flowKt__DelayKt$debounce$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounce$2) create(coroutineScope, (FlowCollector) obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        r3.handleBuilderException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00bb -> B:30:0x00bd). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2;
        CoroutineScope coroutineScope;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        Object obj2;
        SelectBuilderImpl selectBuilderImpl;
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$22;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.p$;
            FlowCollector flowCollector2 = this.p$0;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope2, null, -1, new FlowKt__DelayKt$debounce$2$values$1(this, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = null;
            flowKt__DelayKt$debounce$2 = this;
            coroutineScope = coroutineScope2;
            receiveChannel = produce$default;
            objectRef = objectRef2;
            flowCollector = flowCollector2;
            obj2 = coroutine_suspended;
            if (objectRef.element != NullSurrogateKt.DONE) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$23 = (FlowKt__DelayKt$debounce$2) this.L$4;
            ResultKt.throwOnFailure(obj);
            flowKt__DelayKt$debounce$2 = this;
            objectRef = (Ref.ObjectRef) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            flowCollector = (FlowCollector) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            obj2 = coroutine_suspended;
            i3 = 1;
            if (objectRef.element != NullSurrogateKt.DONE) {
                flowKt__DelayKt$debounce$2.L$0 = coroutineScope;
                flowKt__DelayKt$debounce$2.L$1 = flowCollector;
                flowKt__DelayKt$debounce$2.L$2 = receiveChannel;
                flowKt__DelayKt$debounce$2.L$3 = objectRef;
                flowKt__DelayKt$debounce$2.L$4 = flowKt__DelayKt$debounce$2;
                flowKt__DelayKt$debounce$2.label = i3;
                SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(flowKt__DelayKt$debounce$2);
                try {
                } catch (Throwable th) {
                    th = th;
                    selectBuilderImpl = selectBuilderImpl2;
                    flowKt__DelayKt$debounce$22 = flowKt__DelayKt$debounce$2;
                }
                selectBuilderImpl2.invoke(receiveChannel.getOnReceiveOrNull(), new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1(null, flowKt__DelayKt$debounce$2, receiveChannel, objectRef, flowCollector));
                T t = objectRef.element;
                if (t != 0) {
                    selectBuilderImpl = selectBuilderImpl2;
                    flowKt__DelayKt$debounce$22 = flowKt__DelayKt$debounce$2;
                    selectBuilderImpl.onTimeout(flowKt__DelayKt$debounce$2.$timeoutMillis, new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(t, null, selectBuilderImpl2, flowKt__DelayKt$debounce$2, receiveChannel, objectRef, flowCollector));
                } else {
                    selectBuilderImpl = selectBuilderImpl2;
                    flowKt__DelayKt$debounce$22 = flowKt__DelayKt$debounce$2;
                }
                Object result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$debounce$22);
                }
                if (result != obj2) {
                    return obj2;
                }
                flowKt__DelayKt$debounce$2 = flowKt__DelayKt$debounce$22;
                i3 = 1;
                if (objectRef.element != NullSurrogateKt.DONE) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
