package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "e", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", f = "Errors.kt", i = {0, 0, 0, 0}, l = {230}, m = "invokeSuspend", n = {"$this$catch", "e", "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class FlowKt__ErrorsKt$onErrorCollect$2 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Flow $fallback;
    public final /* synthetic */ Function1 $predicate;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public FlowCollector p$;
    public Throwable p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$onErrorCollect$2(Function1 function1, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.$predicate = function1;
        this.$fallback = flow;
    }

    public final Continuation<Unit> create(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FlowKt__ErrorsKt$onErrorCollect$2 flowKt__ErrorsKt$onErrorCollect$2 = new FlowKt__ErrorsKt$onErrorCollect$2(this.$predicate, this.$fallback, continuation);
        flowKt__ErrorsKt$onErrorCollect$2.p$ = flowCollector;
        flowKt__ErrorsKt$onErrorCollect$2.p$0 = th;
        return flowKt__ErrorsKt$onErrorCollect$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        return ((FlowKt__ErrorsKt$onErrorCollect$2) create((FlowCollector) obj, th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Throwable th = this.p$0;
            if (((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                Flow flow = this.$fallback;
                this.L$0 = flowCollector;
                this.L$1 = th;
                this.L$2 = flowCollector;
                this.L$3 = flow;
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$3;
            FlowCollector flowCollector2 = (FlowCollector) this.L$2;
            Throwable th2 = (Throwable) this.L$1;
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
