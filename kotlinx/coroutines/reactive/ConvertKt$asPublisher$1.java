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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.ConvertKt$asPublisher$1", f = "Convert.kt", i = {0, 1}, l = {16, 17}, m = "invokeSuspend", n = {"$this$publish", "$this$publish"}, s = {"L$0", "L$0"})
/* loaded from: classes2.dex */
public final class ConvertKt$asPublisher$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel<T> $this_asPublisher;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.channels.ReceiveChannel<? extends T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConvertKt$asPublisher$1(ReceiveChannel<? extends T> receiveChannel, Continuation<? super ConvertKt$asPublisher$1> continuation) {
        super(2, continuation);
        this.$this_asPublisher = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConvertKt$asPublisher$1 convertKt$asPublisher$1 = new ConvertKt$asPublisher$1(this.$this_asPublisher, continuation);
        convertKt$asPublisher$1.L$0 = obj;
        return convertKt$asPublisher$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((ConvertKt$asPublisher$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator<T> it;
        ConvertKt$asPublisher$1<T> convertKt$asPublisher$1;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    it = (ChannelIterator) this.L$1;
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
                    T next = it.next();
                    convertKt$asPublisher$12.L$0 = producerScope2;
                    convertKt$asPublisher$12.L$1 = it;
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
            producerScope = (ProducerScope) this.L$0;
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
