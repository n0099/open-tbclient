package kotlinx.coroutines.reactive;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.Mutex;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0002 \u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "R", "T", AdvanceSetting.NETWORK_TYPE, "Lkotlinx/coroutines/sync/Mutex;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectClause2$1", f = "Publish.kt", i = {0}, l = {125}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class PublisherCoroutine$registerSelectClause2$1 extends SuspendLambda implements Function2<Mutex, Continuation<? super R>, Object> {
    public final /* synthetic */ Function2 $block;
    public final /* synthetic */ Object $element;
    public Object L$0;
    public int label;
    public Mutex p$0;
    public final /* synthetic */ PublisherCoroutine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$registerSelectClause2$1(PublisherCoroutine publisherCoroutine, Object obj, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = publisherCoroutine;
        this.$element = obj;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PublisherCoroutine$registerSelectClause2$1 publisherCoroutine$registerSelectClause2$1 = new PublisherCoroutine$registerSelectClause2$1(this.this$0, this.$element, this.$block, continuation);
        publisherCoroutine$registerSelectClause2$1.p$0 = (Mutex) obj;
        return publisherCoroutine$registerSelectClause2$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Mutex mutex, Object obj) {
        return ((PublisherCoroutine$registerSelectClause2$1) create(mutex, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex = this.p$0;
            this.this$0.doLockedNext(this.$element);
            Function2 function2 = this.$block;
            PublisherCoroutine publisherCoroutine = this.this$0;
            this.L$0 = mutex;
            this.label = 1;
            obj = function2.invoke(publisherCoroutine, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Mutex mutex2 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
