package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.reactive.ConvertKt$asPublisher$1", f = "Convert.kt", i = {0, 1, 1}, l = {22, 23}, m = "invokeSuspend", n = {"$this$publish", "$this$publish", "t"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes9.dex */
public final class ConvertKt$asPublisher$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel $this_asPublisher;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConvertKt$asPublisher$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_asPublisher = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConvertKt$asPublisher$1 convertKt$asPublisher$1 = new ConvertKt$asPublisher$1(this.$this_asPublisher, continuation);
        convertKt$asPublisher$1.p$ = (ProducerScope) obj;
        return convertKt$asPublisher$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ConvertKt$asPublisher$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator it;
        ConvertKt$asPublisher$1<T> convertKt$asPublisher$1;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    it = (ChannelIterator) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    producerScope = (ProducerScope) this.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                it = (ChannelIterator) this.L$1;
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ConvertKt$asPublisher$1<T> convertKt$asPublisher$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    convertKt$asPublisher$12.L$0 = producerScope2;
                    convertKt$asPublisher$12.L$1 = next;
                    convertKt$asPublisher$12.L$2 = it;
                    convertKt$asPublisher$12.label = 2;
                    if (producerScope2.send(next, convertKt$asPublisher$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope = producerScope2;
                    convertKt$asPublisher$1 = convertKt$asPublisher$12;
                    convertKt$asPublisher$1.L$0 = producerScope;
                    convertKt$asPublisher$1.L$1 = it;
                    convertKt$asPublisher$1.label = 1;
                    hasNext = it.hasNext(convertKt$asPublisher$1);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ConvertKt$asPublisher$1<T> convertKt$asPublisher$13 = convertKt$asPublisher$1;
                    producerScope2 = producerScope;
                    obj = hasNext;
                    convertKt$asPublisher$12 = convertKt$asPublisher$13;
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            it = this.$this_asPublisher.iterator();
        }
        convertKt$asPublisher$1 = this;
        convertKt$asPublisher$1.L$0 = producerScope;
        convertKt$asPublisher$1.L$1 = it;
        convertKt$asPublisher$1.label = 1;
        hasNext = it.hasNext(convertKt$asPublisher$1);
        if (hasNext != coroutine_suspended) {
        }
    }
}
