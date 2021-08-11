package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {0, 0, 1, 1}, l = {214, 214}, m = "invokeSuspend", n = {"$this$transformLatest", AdvanceSetting.NETWORK_TYPE, "$this$transformLatest", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2 $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public FlowCollector p$;
    public Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$mapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, T t, Continuation<? super Unit> continuation) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, continuation);
        flowKt__MergeKt$mapLatest$1.p$ = flowCollector;
        flowKt__MergeKt$mapLatest$1.p$0 = t;
        return flowKt__MergeKt$mapLatest$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return ((FlowKt__MergeKt$mapLatest$1) create((FlowCollector) obj, obj2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = this.p$;
            Object obj3 = this.p$0;
            Function2 function2 = this.$transform;
            this.L$0 = flowCollector;
            this.L$1 = obj3;
            this.L$2 = flowCollector;
            this.label = 1;
            Object invoke = function2.invoke(obj3, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            obj2 = obj3;
            obj = invoke;
        } else if (i2 != 1) {
            if (i2 == 2) {
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$2;
            obj2 = this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = flowCollector2;
        this.L$1 = obj2;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
