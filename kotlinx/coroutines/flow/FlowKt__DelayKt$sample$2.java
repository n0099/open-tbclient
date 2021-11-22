package kotlinx.coroutines.flow;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.tieba.ala.ALaKeepAliveService;
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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {185}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", SavedStateHandle.VALUES, "lastValue", ALaKeepAliveService.KEY_TICKER}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $periodMillis;
    public final /* synthetic */ Flow $this_sample;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public CoroutineScope p$;
    public FlowCollector p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(Flow flow, long j, Continuation continuation) {
        super(3, continuation);
        this.$this_sample = flow;
        this.$periodMillis = j;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$this_sample, this.$periodMillis, continuation);
        flowKt__DelayKt$sample$2.p$ = coroutineScope;
        flowKt__DelayKt$sample$2.p$0 = flowCollector;
        return flowKt__DelayKt$sample$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2) create(coroutineScope, (FlowCollector) obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:8|(1:9)|10|11|12|13|14|(1:16)|(1:18)|5|6|(2:26|27)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r1.handleBuilderException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b7 -> B:26:0x00ba). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel produce$default;
        Ref.ObjectRef objectRef;
        ReceiveChannel fixedPeriodTicker$default;
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2;
        CoroutineScope coroutineScope;
        ReceiveChannel receiveChannel;
        Object obj2;
        SelectBuilderImpl selectBuilderImpl;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.p$;
            flowCollector = this.p$0;
            produce$default = ProduceKt.produce$default(coroutineScope2, null, -1, new FlowKt__DelayKt$sample$2$values$1(this, null), 1, null);
            objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            fixedPeriodTicker$default = FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope2, this.$periodMillis, 0L, 2, null);
            flowKt__DelayKt$sample$2 = this;
            coroutineScope = coroutineScope2;
            receiveChannel = fixedPeriodTicker$default;
            obj2 = coroutine_suspended;
            if (objectRef.element == NullSurrogateKt.DONE) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$22 = (FlowKt__DelayKt$sample$2) this.L$5;
            ResultKt.throwOnFailure(obj);
            flowKt__DelayKt$sample$2 = this;
            receiveChannel = (ReceiveChannel) this.L$4;
            objectRef = (Ref.ObjectRef) this.L$3;
            produce$default = (ReceiveChannel) this.L$2;
            flowCollector = (FlowCollector) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            obj2 = coroutine_suspended;
            i3 = 1;
            if (objectRef.element == NullSurrogateKt.DONE) {
                flowKt__DelayKt$sample$2.L$0 = coroutineScope;
                flowKt__DelayKt$sample$2.L$1 = flowCollector;
                flowKt__DelayKt$sample$2.L$2 = produce$default;
                flowKt__DelayKt$sample$2.L$3 = objectRef;
                flowKt__DelayKt$sample$2.L$4 = receiveChannel;
                flowKt__DelayKt$sample$2.L$5 = flowKt__DelayKt$sample$2;
                flowKt__DelayKt$sample$2.label = i3;
                SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(flowKt__DelayKt$sample$2);
                try {
                } catch (Throwable th) {
                    th = th;
                    selectBuilderImpl = selectBuilderImpl2;
                }
                selectBuilderImpl = selectBuilderImpl2;
                selectBuilderImpl.invoke(produce$default.getOnReceiveOrNull(), new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(null, produce$default, receiveChannel, objectRef, flowCollector));
                selectBuilderImpl.invoke(receiveChannel.getOnReceive(), new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(null, produce$default, receiveChannel, objectRef, flowCollector));
                Object result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$sample$2);
                }
                if (result == obj2) {
                    return obj2;
                }
                i3 = 1;
                if (objectRef.element == NullSurrogateKt.DONE) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
