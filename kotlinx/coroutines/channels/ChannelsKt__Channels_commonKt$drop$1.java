package kotlinx.coroutines.channels;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {700, SDKLogTypeConstants.SEND_PLAY_FAIL_TYPE, SDKLogTypeConstants.CLOSE_GAME_TYPE}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
/* loaded from: classes3.dex */
public final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel $this_drop;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public ProducerScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i2, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, continuation);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:24:0x0086). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d8 -> B:34:0x00a9). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i2;
        Object obj2;
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1;
        ProducerScope producerScope2;
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$12;
        ChannelIterator it;
        int i3;
        ChannelIterator it2;
        Object hasNext;
        ProducerScope producerScope3;
        Object hasNext2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            if (this.$n >= 0) {
                int i5 = this.$n;
                if (i5 > 0) {
                    producerScope2 = producerScope;
                    channelsKt__Channels_commonKt$drop$12 = this;
                    it = this.$this_drop.iterator();
                    i3 = i5;
                    ChannelIterator channelIterator = it;
                    channelsKt__Channels_commonKt$drop$12.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$drop$12.I$0 = i3;
                    channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator;
                    channelsKt__Channels_commonKt$drop$12.label = 1;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                    }
                } else {
                    i2 = i5;
                    obj2 = coroutine_suspended;
                    channelsKt__Channels_commonKt$drop$1 = this;
                    it2 = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i2;
                    channelsKt__Channels_commonKt$drop$1.L$1 = it2;
                    channelsKt__Channels_commonKt$drop$1.label = 2;
                    hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
                    if (hasNext2 != obj2) {
                    }
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            }
        } else if (i4 == 1) {
            int i6 = this.I$0;
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope4 = (ProducerScope) this.L$0;
            i2 = i6;
            ChannelIterator channelIterator2 = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelIterator2.next();
                int i7 = i2 - 1;
                if (i7 == 0) {
                    i2 = i7;
                } else {
                    producerScope2 = producerScope4;
                    it = channelIterator2;
                    i3 = i7;
                    channelsKt__Channels_commonKt$drop$12 = channelsKt__Channels_commonKt$drop$1;
                    coroutine_suspended = obj2;
                    ChannelIterator channelIterator3 = it;
                    channelsKt__Channels_commonKt$drop$12.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$drop$12.I$0 = i3;
                    channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator3;
                    channelsKt__Channels_commonKt$drop$12.label = 1;
                    hasNext = channelIterator3.hasNext(channelsKt__Channels_commonKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    channelsKt__Channels_commonKt$drop$1 = channelsKt__Channels_commonKt$drop$12;
                    obj = hasNext;
                    producerScope4 = producerScope2;
                    i2 = i3;
                    channelIterator2 = channelIterator3;
                    obj2 = obj3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
            }
            producerScope = producerScope4;
            it2 = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$drop$1.I$0 = i2;
            channelsKt__Channels_commonKt$drop$1.L$1 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext2 != obj2) {
            }
        } else if (i4 == 2) {
            int i8 = this.I$0;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i8;
            it2 = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
        } else if (i4 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i9 = this.I$0;
            ResultKt.throwOnFailure(obj);
            i2 = i9;
            producerScope = (ProducerScope) this.L$0;
            it2 = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$drop$1.I$0 = i2;
            channelsKt__Channels_commonKt$drop$1.L$1 = it2;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext2 != obj2) {
                return obj2;
            }
            producerScope3 = producerScope;
            obj = hasNext2;
            if (!((Boolean) obj).booleanValue()) {
                Object next = it2.next();
                channelsKt__Channels_commonKt$drop$1.L$0 = producerScope3;
                channelsKt__Channels_commonKt$drop$1.I$0 = i2;
                channelsKt__Channels_commonKt$drop$1.L$1 = next;
                channelsKt__Channels_commonKt$drop$1.L$2 = it2;
                channelsKt__Channels_commonKt$drop$1.label = 3;
                if (producerScope3.send(next, channelsKt__Channels_commonKt$drop$1) == obj2) {
                    return obj2;
                }
                producerScope = producerScope3;
                channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                channelsKt__Channels_commonKt$drop$1.I$0 = i2;
                channelsKt__Channels_commonKt$drop$1.L$1 = it2;
                channelsKt__Channels_commonKt$drop$1.label = 2;
                hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$drop$1);
                if (hasNext2 != obj2) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
