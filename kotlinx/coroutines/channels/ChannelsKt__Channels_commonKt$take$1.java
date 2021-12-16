package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {994, 995}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$take$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel $this_take;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$take$1(ReceiveChannel receiveChannel, int i2, Continuation continuation) {
        super(2, continuation);
        this.$this_take = receiveChannel;
        this.$n = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1 = new ChannelsKt__Channels_commonKt$take$1(this.$this_take, this.$n, continuation);
        channelsKt__Channels_commonKt$take$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$take$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$take$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0085 -> B:29:0x0087). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i2;
        ChannelIterator it;
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$1;
        ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$12;
        ProducerScope producerScope2;
        int i3;
        ChannelIterator channelIterator;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            int i5 = this.$n;
            if (i5 == 0) {
                return Unit.INSTANCE;
            }
            if (i5 >= 0) {
                i2 = this.$n;
                it = this.$this_take.iterator();
                channelsKt__Channels_commonKt$take$1 = this;
                channelsKt__Channels_commonKt$take$1.L$0 = producerScope;
                channelsKt__Channels_commonKt$take$1.I$0 = i2;
                channelsKt__Channels_commonKt$take$1.L$1 = it;
                channelsKt__Channels_commonKt$take$1.label = 1;
                hasNext = it.hasNext(channelsKt__Channels_commonKt$take$1);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            }
        } else if (i4 == 1) {
            channelIterator = (ChannelIterator) this.L$1;
            i3 = this.I$0;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$take$12 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
        } else if (i4 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            channelIterator = (ChannelIterator) this.L$2;
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            channelsKt__Channels_commonKt$take$1 = this;
            int i6 = i3 - 1;
            if (i6 != 0) {
                return Unit.INSTANCE;
            }
            it = channelIterator;
            i2 = i6;
            channelsKt__Channels_commonKt$take$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$take$1.I$0 = i2;
            channelsKt__Channels_commonKt$take$1.L$1 = it;
            channelsKt__Channels_commonKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__Channels_commonKt$take$1);
            if (hasNext != coroutine_suspended) {
                return coroutine_suspended;
            }
            ChannelsKt__Channels_commonKt$take$1 channelsKt__Channels_commonKt$take$13 = channelsKt__Channels_commonKt$take$1;
            producerScope2 = producerScope;
            obj = hasNext;
            channelsKt__Channels_commonKt$take$12 = channelsKt__Channels_commonKt$take$13;
            ChannelIterator channelIterator2 = it;
            i3 = i2;
            channelIterator = channelIterator2;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                channelsKt__Channels_commonKt$take$12.L$0 = producerScope2;
                channelsKt__Channels_commonKt$take$12.I$0 = i3;
                channelsKt__Channels_commonKt$take$12.L$1 = next;
                channelsKt__Channels_commonKt$take$12.L$2 = channelIterator;
                channelsKt__Channels_commonKt$take$12.label = 2;
                if (producerScope2.send(next, channelsKt__Channels_commonKt$take$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                producerScope = producerScope2;
                channelsKt__Channels_commonKt$take$1 = channelsKt__Channels_commonKt$take$12;
                int i62 = i3 - 1;
                if (i62 != 0) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
