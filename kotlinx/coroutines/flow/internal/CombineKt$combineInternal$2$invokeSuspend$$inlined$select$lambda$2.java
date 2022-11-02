package kotlinx.coroutines.flow.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$onReceive$1", "kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$$special$$inlined$onReceive$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel[] $channels$inlined;
    public final /* synthetic */ int $i$inlined;
    public final /* synthetic */ Boolean[] $isClosed$inlined;
    public final /* synthetic */ Object[] $latestValues$inlined;
    public final /* synthetic */ Ref.IntRef $nonClosed$inlined;
    public final /* synthetic */ Function2 $onReceive;
    public final /* synthetic */ Ref.IntRef $remainingNulls$inlined;
    public final /* synthetic */ int $size$inlined;
    public Object L$0;
    public int label;
    public Object p$0;
    public final /* synthetic */ CombineKt$combineInternal$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(Function2 function2, Continuation continuation, int i, CombineKt$combineInternal$2 combineKt$combineInternal$2, int i2, Boolean[] boolArr, ReceiveChannel[] receiveChannelArr, Object[] objArr, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(2, continuation);
        this.$onReceive = function2;
        this.$i$inlined = i;
        this.this$0 = combineKt$combineInternal$2;
        this.$size$inlined = i2;
        this.$isClosed$inlined = boolArr;
        this.$channels$inlined = receiveChannelArr;
        this.$latestValues$inlined = objArr;
        this.$remainingNulls$inlined = intRef;
        this.$nonClosed$inlined = intRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(this.$onReceive, continuation, this.$i$inlined, this.this$0, this.$size$inlined, this.$isClosed$inlined, this.$channels$inlined, this.$latestValues$inlined, this.$remainingNulls$inlined, this.$nonClosed$inlined);
        combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2.p$0 = obj;
        return combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object obj2 = this.p$0;
            if (obj2 == null) {
                this.$isClosed$inlined[this.$i$inlined] = Boxing.boxBoolean(true);
                Ref.IntRef intRef = this.$nonClosed$inlined;
                intRef.element--;
            } else {
                Function2 function2 = this.$onReceive;
                this.L$0 = obj2;
                this.label = 1;
                if (function2.invoke(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
